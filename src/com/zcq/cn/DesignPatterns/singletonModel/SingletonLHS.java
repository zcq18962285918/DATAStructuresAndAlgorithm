package com.zcq.cn.DesignPatterns.singletonModel;

/**
 * 某个类的实例对象只有一个
 */
public class SingletonLHS {
	private static SingletonLHS singletonLHS;

	private SingletonLHS() {

	}

	/**
	 * synchronized保证线程安全
	 * @return
	 */
	public static synchronized SingletonLHS getInstance() {
		if (null == singletonLHS) {
			singletonLHS = new SingletonLHS();
		}
		return singletonLHS;
	}
}
