package com.wei.thread.synchronize;

public class MyThread extends Thread {

	private User u;
	private int count;
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public MyThread(String name,User u,int count){
		super(name);
		this.u = u;
		this.count = count;
	}
	@Override
	public void run() {
		u.operate(count);
	}
}
