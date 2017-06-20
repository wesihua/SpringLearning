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
			System.out.println(Thread.currentThread().getName()+"����ʼִ��");
		}
	}
	
	public Thread getThread(String name){
		return new MyThread(name);
	}
	
	public static void main(String[] args) {
		SimpleDemo demo = new SimpleDemo();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(demo.getThread("�߳�-1"));
		pool.execute(demo.getThread("�߳�-2"));
		pool.execute(demo.getThread("�߳�-3"));
		//pool.execute(demo.getThread("�߳�-4"));
		//pool.execute(demo.getThread("�߳�-5"));
		
		//�߳�ֻ��ִ��һ��
		pool.shutdownNow();
		//�߳�ִ�еĴ���Ϊ��ӵ��߳�����
		//pool.shutdown();
	}
}
