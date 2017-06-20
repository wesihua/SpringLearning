package com.wei.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDemo {

	class MyThread extends Thread{
		
		public MyThread(String name){
			super(name);
		}
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+"：开始执行");
		}
	}
	
	public Thread getThread(String name){
		return new MyThread(name);
	}
	
	public static void main(String[] args) {
		SimpleDemo demo = new SimpleDemo();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(demo.getThread("线程-1"));
		pool.execute(demo.getThread("线程-2"));
		pool.execute(demo.getThread("线程-3"));
		//pool.execute(demo.getThread("线程-4"));
		//pool.execute(demo.getThread("线程-5"));
		
		//线程只会执行一次
		pool.shutdownNow();
		//线程执行的次数为添加的线程总数
		//pool.shutdown();
	}
}
