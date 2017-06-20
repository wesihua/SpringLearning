package com.wei.thread;

import com.wei.spring.bean.Person;

public class WaitThread extends Thread {

	private Person p;
	
	public WaitThread(Person p,String name){
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
		System.out.println(Thread.currentThread().getName()+"开始等待");
		long beginTime = System.currentTimeMillis();
		synchronized (p) {
			try {
				p.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long waitTime = System.currentTimeMillis() - beginTime;
		System.out.println(Thread.currentThread().getName()+"结束等待，等待时间："+waitTime);
	}
}

