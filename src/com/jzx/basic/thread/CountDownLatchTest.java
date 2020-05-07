package com.sdsc.basic.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);
		LatchDemo latchDemo = new LatchDemo(latch);
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 5; ++i) {
			new Thread(latchDemo).start();
		}
		try {
			System.out.println("wait start");
			latch.await();
			System.out.println("wait end");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}

}

class LatchDemo implements Runnable {
	private CountDownLatch latch;

	public LatchDemo(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		synchronized (this) {
			try {
				for (int i = 0; i < 500; i++) {
					if (i % 10 == 0) {
						System.out.println(i);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				latch.countDown();
			}
		}
	}

}
