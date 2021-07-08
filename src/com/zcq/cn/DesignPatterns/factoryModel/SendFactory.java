package com.zcq.cn.DesignPatterns.factoryModel;

public class SendFactory {
	public static Sender produceMail() {
		return new MailSender();
	}

	public static Sender produceSms() {
		return new SmsSender();
	}

	public static Sender produceQQ() {
		return new QQSender();
	}
}
