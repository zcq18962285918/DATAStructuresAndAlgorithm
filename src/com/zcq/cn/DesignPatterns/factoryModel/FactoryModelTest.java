package com.zcq.cn.DesignPatterns.factoryModel;

public class FactoryModelTest {

	/**
	 * 工厂模式
	 * 定义与场合: 需要创建几个对象，且这几个对象有共同特征
	 */
	public static void main(String[] args) {
		Sender sender = SendFactory.produceMail();
		sender.send();

		Sender sender1 = SendFactory.produceQQ();
		sender1.send();
	}

}
