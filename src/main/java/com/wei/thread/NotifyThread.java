package com.wei.thread;

import com.wei.spring.bean.Person;

public class NotifyThread extends Thread {

	private Person p;
	
	public NotifyThread(Person p,String name){
		super(name);
		this.p = p;
	}
	
	public Person getP() {
		return p;
	}

	public void setP(Person p) {
		this.p = p;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		synchronized (p) {
			p.notifyAll();
		}
	}
	
	
}
