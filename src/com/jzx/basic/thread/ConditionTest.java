package com.jzx.basic.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
	public static void main(String[] args) {

		int runNum = 20;
		int threadNum = 3;
		MyConditionTest demo = new MyConditionTest(runNum, threadNum);
		for (int i = 0; i < threadNum; i++) {
			new Thread(demo, (char) (i + 'a') + "").start();
		}
	}
}

class MyConditionTest implements Runnable {
	private ReentrantLock lock = new ReentrantLock();
	private char first = 'a';
	private int runNum;
	private int threadNum;
	private Condition[] condition;

	public MyConditionTest(int runNum, int threadNum) {
		this.runNum = runNum;
		this.threadNum = threadNum;
		condition = new Condition[this.runNum];
		for (int i = 0; i < condition.length; i++) {
			condition[i] = lock.newCondition();
		}
	}

	@Override
	public void run() {
		for (int i = 0; i <= runNum; i++) {
			lock.lock();
			char currentThreadName = (char) Thread.currentThread().getName().charAt(0);
			try {
				if (currentThreadName != first) {
					condition[currentThreadName - 'a'].await();
				}
				System.out.println(currentThreadName + "\t" + i);
				first = (char) ('a' + (currentThreadName + 1 - 'a') % threadNum);
				condition[first - 'a'].signal();
				Thread.sleep(100);
			} catch (Exception e) {
			} finally {
				lock.unlock();
			}
		}
	}

}
