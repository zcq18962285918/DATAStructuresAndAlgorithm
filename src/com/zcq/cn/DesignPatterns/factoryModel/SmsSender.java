package com.zcq.cn.DesignPatterns.factoryModel;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("smsSender!");
	}
}
