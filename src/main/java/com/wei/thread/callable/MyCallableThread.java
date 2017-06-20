package com.wei.thread.callable;

import java.util.concurrent.Callable;

import com.wei.spring.bean.Person;

public class MyCallableThread implements Callable<Person> {

	@Override
	public Person call() throws Exception {
		Person p = new Person();
		p.setAge(100);
		p.setName("Callable Test");
		return p;
	}

}
