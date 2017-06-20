package com.wei.thread;

public class MyThread extends Thread {

	private String name;
	
	public MyThread(){}
	
	public MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i=0; i < 10; i++){
			System.out.println("线程：   "+name+"   开始运行-->"+i);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("遇见遗憾");
		MyThread t2 = new MyThread("xxx");
		
		t1.start();
		t2.start();
	}
}
