package com.zcq.cn.DesignPatterns.proxyModel;

public class WeddingCompany implements ProxyInterface {

	private ProxyInterface proxyInterface;

	public WeddingCompany(ProxyInterface proxyInterface) {
		this.proxyInterface = proxyInterface;
	}

	@Override
	public void marry() {
		System.out.println("婚礼开始");
		proxyInterface.marry();
		System.out.println("婚礼结束");
	}
}
