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
			System.out.println(Thread.currentThread().getName()+"开始执行");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Thread getThread(String name){
		return new MyThread(name);
	}
	
	public static void main(String[] args) {
		SimpleDemo demo = new SimpleDemo();
		//ExecutorService pool = Executors.newFixedThreadPool(2);
		//ExecutorService pool = Executors.newSingleThreadExecutor();
		ExecutorService pool = Executors.newCachedThreadPool();
		pool.execute(demo.getThread("线程1"));
		pool.execute(demo.getThread("线程2"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.execute(demo.getThread("线程3"));
		pool.submit(demo.getThread("测试"));
		//pool.execute(demo.getThread("线程4"));
		//pool.execute(demo.getThread("线程5"));
		
		//pool.shutdownNow();
		pool.shutdown();
	}
}
