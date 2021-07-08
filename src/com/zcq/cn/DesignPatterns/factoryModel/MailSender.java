package com.zcq.cn.DesignPatterns.factoryModel;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("mailSender!");
	}
}
