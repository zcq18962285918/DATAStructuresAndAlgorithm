package com.zcq.cn.DesignPatterns.observerModel;

public class ConcretePerson implements Person {

	@Override
	public void getMessage() {
		System.out.println("收到消息!");
	}
}
