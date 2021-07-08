package com.zcq.cn.DesignPatterns.proxyModel;

public class ProxyTest {
	public static void main(String[] args) {
		WeddingCompany weddingCompany = new WeddingCompany(new NormalHome());
		weddingCompany.marry();
	}
}
