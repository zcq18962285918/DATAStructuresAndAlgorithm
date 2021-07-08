package com.zcq.cn.DesignPatterns.abstractFactoryModel;

import com.zcq.cn.DesignPatterns.factoryModel.MailSender;
import com.zcq.cn.DesignPatterns.factoryModel.Sender;

public class SendMailFactory implements Provider{
	@Override
	public Sender produce() {
		return new MailSender();
	}
}
