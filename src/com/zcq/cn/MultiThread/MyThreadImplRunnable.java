package com.zcq.cn.MultiThread;

public class MyThreadImplRunnable implements Runnable{
	@Override
	public void run() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count++;
			System.out.println(Thread.currentThread().getName() + "thread running" + count);
		}
	}
}
