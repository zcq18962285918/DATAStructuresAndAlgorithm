package com.zcq.cn.DesignPatterns.singletonModel;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * 采用双锁机制，安全且在多线程情况下能保持高性能。
 */
public class SingleonDCL {
	private volatile static SingleonDCL singletionDCL;

	private SingleonDCL() {

	}

	public static SingleonDCL singletionDCL() {
		if (null == singletionDCL) {
			synchronized (SingleonDCL.class) {
				if (null == singletionDCL) {
					singletionDCL = new SingleonDCL();
				}
			}
		}
		return singletionDCL;
	}
}
