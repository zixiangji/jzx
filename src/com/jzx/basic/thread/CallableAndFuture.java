package com.jzx.basic.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 带有返回值的线程Callable和Future操作
 *
 * @author root
 *
 */
public class CallableAndFuture {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<Integer>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Future<Integer> result = executor.submit(new CallFuture(i));
			results.add(result);
		}
		for (Future<Integer> future : results) {
			System.out.println(future.get());
		}
		System.out.println("executor is shutdown? " + executor.isShutdown());
	}
}

class CallFuture implements Callable<Integer> {

	private static final int PI = 2;
	private int size;

	public CallFuture(int size) {
		this.size = size;
	}

	@Override
	public Integer call() throws Exception {
		try {
			int random = new Random().nextInt(100);
			Thread.sleep(random * 1000);
		} catch (Exception e) {
		}
		return size * PI;
	}
}
