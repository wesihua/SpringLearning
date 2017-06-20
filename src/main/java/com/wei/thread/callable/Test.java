package com.wei.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.wei.spring.bean.Person;

public class Test {

	public static void main(String[] args) {

		MyCallableThread callable = new MyCallableThread();
		FutureTask<Person> task = new FutureTask<Person>(callable);
		new Thread(task).start();
		try {
			Person p = task.get();
			System.out.println(p.getAge()+"----"+p.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
