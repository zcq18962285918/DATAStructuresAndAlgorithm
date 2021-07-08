package com.zcq.cn.DesignPatterns.observerModel;

public class ConcreteSubject extends Subject {
	public void getSmsMessage() {
		super.notifyPerson();
	}
}
