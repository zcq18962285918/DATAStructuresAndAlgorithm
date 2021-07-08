package com.zcq.cn.DesignPatterns.observerModel;

public class ObserverTest {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		ConcretePerson person = new ConcretePerson();
		subject.addPerson(person);
		subject.getSmsMessage();
	}
}
