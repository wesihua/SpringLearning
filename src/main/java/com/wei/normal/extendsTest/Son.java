package com.wei.normal.extendsTest;

import java.util.ArrayList;
import java.util.List;

public class Son extends Parent {
	
	static {
		System.out.println("a");
	}
	
	public Son() {
		System.out.println("b");
	}
	
	// 测试初始化的顺序.先普通变量，后构造函数。先父类后子类
	// 普通代码块与变量同级，按出现顺序执行
	public static void main(String[] args) {
		System.out.println("xxxxxxxxxxx");
		Parent a = new Son();
		a = new Son();
	}
	
	/******************结果*******************/
	/*
		ParentLog 开始初始化了
		我是父类
		sonLog 开始初始化了
		我是子类
	*/
	/******************结果*******************/
}
