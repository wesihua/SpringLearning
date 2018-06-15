package com.wei.thread.test;

import java.util.concurrent.ConcurrentHashMap;

import com.wei.spring.bean.Person;
import com.wei.thread.NotifyThread;
import com.wei.thread.WaitThread;

public class WaitNotifyTest {

	public static void main(String[] args) {
		Person p = new Person();
		WaitThread w1 = new WaitThread(p,"wait-1");
		WaitThread w2 = new WaitThread(p,"wait-2");
		WaitThread w3 = new WaitThread(p,"wait-3");
		
		NotifyThread n = new NotifyThread(p,"notify-1");
		
		w1.start();
		w2.start();
		w3.start();
		n.start();
		
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
	}
}
