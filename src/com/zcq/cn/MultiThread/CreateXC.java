package com.zcq.cn.MultiThread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateXC {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		// 继承Thread类, 多个线程之间无法共享该线程类的实例变量
		/*MyThread myThread = new MyThread();
		myThread.start();*/
		// 实现Runnable接口, 资源共享
		/*MyThreadImplRunnable myThreadImplRunnable = new MyThreadImplRunnable();
		Thread thread = new Thread(myThreadImplRunnable);
		thread.start();*/
		// 使用Callable，方法中可以有返回值，并且抛出异常。
		/*MyThreadImplCallable myThreadImplCallable = new MyThreadImplCallable();
		FutureTask<String> stringFutureTask = new FutureTask<>(myThreadImplCallable);
		Thread myThread = new Thread(stringFutureTask);
		myThread.start();*/

		// 创建线程池实现，线程池提供了一个线程队列，队列中保存所有等待状态的线程，避免创建与销毁额外开销，提高了响应速度。
		// 通过线程池工厂创建线程数量为2的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		// 执行线程,execute()适用于实现Runnable接口创建的线程
		executorService.execute(new MyThreadImplRunnable());

		/* //submit()适用于实现Callable接口创建的线程
		Future<String> submit = executorService.submit(new MyThreadImplCallable());
		String s = submit.get();
		System.out.println(s);*/
		executorService.shutdown();



		// 守护线程
		/*// 启动后默认启动一个主线程
		// 设置一个钩子函数, 在JVM退出时输出日志
		Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM exit success")));
		// 创建一个线程(默认非守护线程)
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("running");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
//		thread.setDaemon(true); // 把这个线程设置为守护线程, 设置后程序退出
		thread.start();
		TimeUnit.SECONDS.sleep(2); //程序运行后休眠2s输出exit
		System.out.println("exit");*/
	}



}
