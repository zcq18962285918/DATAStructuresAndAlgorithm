package com.zcq.cn.DesignPatterns.abstractFactoryModel;

import com.zcq.cn.DesignPatterns.factoryModel.Sender;

public class AbstractFactoryModelTest {

	public static void main(String[] args) {
		Provider provider = new SendMailFactory();
		Sender sender = provider.produce();
		sender.send();
	}
}
