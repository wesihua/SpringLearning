package com.wei.normal.extendsTest;

import org.springframework.transaction.PlatformTransactionManager;

public class LogClass {

	public LogClass(String name) {
		System.out.println(name + " 开始初始化了");
		
		PlatformTransactionManager  a = null;
	}
}
