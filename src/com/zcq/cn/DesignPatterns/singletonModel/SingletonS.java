package com.zcq.cn.DesignPatterns.singletonModel;

/**
 * 登记式/静态内部类
 */
public class SingletonS {
	private static class SingletonHolder {
		private static final SingletonS INSTANCE = new SingletonS();
	}

	private SingletonS() {

	}

	public static final SingletonS getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
