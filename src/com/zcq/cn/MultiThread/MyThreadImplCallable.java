package com.zcq.cn.MultiThread;

import java.util.concurrent.Callable;

public class MyThreadImplCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		int count = 0;
		for (int i = 0; i < 100; i++) {
			count++;
			System.out.println(Thread.currentThread().getName() + "thread running" + count);
		}
		return "callable<String>";
	}
}
