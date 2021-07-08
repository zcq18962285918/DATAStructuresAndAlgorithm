package com.zcq.cn.MultiThread;

public class MyThread extends Thread{
	@Override
	public void run() {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count++;
			System.out.println(getName() + "thread running" + count);
		}
	}
}
