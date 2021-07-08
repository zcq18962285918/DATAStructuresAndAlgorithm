package com.zcq.cn.DesignPatterns.abstractFactoryModel;

import com.zcq.cn.DesignPatterns.factoryModel.Sender;

public interface Provider {
	public Sender produce();
}
