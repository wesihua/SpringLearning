package com.wei.thread;

public class MyRunnableThread implements Runnable {

	public void run() {
		for(int i=0; i < 1000; i++){
			System.out.println("线程：   "+Thread.currentThread().getName()+"   开始运行-->"+i);
		}
	}

	public static void main(String[] args) {
		MyRunnableThread r = new MyRunnableThread();
		Thread t1 = new Thread(r,"遇见遗憾");
		Thread t2 = new Thread(r,"xxx");
		
		t1.start();
		t2.start();
		
	}
}
