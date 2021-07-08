package com.zcq.cn.DesignPatterns.singletonModel;

public class SingletonEHS {
	private static SingletonEHS singletonEHS = new SingletonEHS();

	private SingletonEHS() {

	}

	private static SingletonEHS getInstance() {
		return singletonEHS;
	}

}
