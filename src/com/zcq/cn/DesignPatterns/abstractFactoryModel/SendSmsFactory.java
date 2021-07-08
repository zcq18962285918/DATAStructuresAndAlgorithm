package com.zcq.cn.DesignPatterns.abstractFactoryModel;

import com.zcq.cn.DesignPatterns.factoryModel.Sender;
import com.zcq.cn.DesignPatterns.factoryModel.SmsSender;

public class SendSmsFactory implements Provider{

	@Override
	public Sender produce() {
		return new SmsSender();
	}
}
