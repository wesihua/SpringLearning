package com.wei.normal.abstractCls;

public abstract class ConstructorTest {

	abstract void draw();
	
	public ConstructorTest() {
		System.out.println("我是一个抽象类，为什么我可以拥有一个构造函数？");
	}
}
