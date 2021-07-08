package com.zcq.cn.DesignPatterns.observerModel;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Person> personList = new ArrayList<>();

	public void addPerson(Person person) {
		personList.add(person);
	}
	public void delPerson(Person person) {
		personList.remove(person);
	}

	// 通知所有观察者
	public void notifyPerson() {
		for (Person person : personList) {
			person.getMessage();
		}
	}
}
