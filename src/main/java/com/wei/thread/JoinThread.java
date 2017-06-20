package com.wei.thread;

public class JoinThread extends Thread {

	@Override
	public void run() {
		System.out.println("线程："+Thread.currentThread().getName()+"开始执行");
		for(int i=0; i < 5; i++){
			System.out.println("线程"+Thread.currentThread().getName()+"执行："+i+"s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("线程："+Thread.currentThread().getName()+"执行结束");
	}
	
	public static void main(String[] args) throws InterruptedException {
		JoinThread t = new JoinThread();
		MyThread t1 = new MyThread("遇见遗憾");
		System.out.println("==线程："+Thread.currentThread().getName()+"开始执行==");
		t.start();
		t1.start();
		t.join();//t执行完之后才会执行最后一句打印【main】,而t1不受影响
		System.out.println("==线程："+Thread.currentThread().getName()+"执行结束==");
	}
}
