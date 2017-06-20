package com.wei.spring.bean;

public class BlackDog implements IDog {

	@Override
	public void bark(String name) {
		System.out.println("BLACKDOG bark bark bark, my name is " + name);
	}

	@Override
	public String sayName(String name) {
		String str = "my name is "+name;
		return str;
	}

	
}
