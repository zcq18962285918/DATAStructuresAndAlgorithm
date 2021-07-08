package com.zcq.cn.DesignPatterns.factoryModel;

public class QQSender implements Sender {
	@Override
	public void send() {
		System.out.println("qqSender");
	}
}
