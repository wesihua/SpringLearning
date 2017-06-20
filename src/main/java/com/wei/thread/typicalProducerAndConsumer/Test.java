package com.wei.thread.typicalProducerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.wei.spring.bean.Person;

public class Test {

	public static void main(String[] args) {
		
		BlockingQueue<Person> queue = new LinkedBlockingQueue<Person>(10);
		
		
		Producer p = new Producer(queue);
		Producer p2 = new Producer(queue);
		Consumer c = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		Consumer c3 = new Consumer(queue);
		Consumer c4 = new Consumer(queue);
		
		/*
		 * 简单启动方式
		 */
//		new Thread(p).start();
//		new Thread(p2).start();
//		new Thread(c).start();
//		new Thread(c2).start();
//		new Thread(c3).start();
//		new Thread(c4).start();
		
		/*
		 * 线程池启动方式
		 */
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.execute(p);
		pool.execute(p2);
		pool.execute(c);
		pool.execute(c2);
		pool.execute(c3);
		pool.execute(c4);
		pool.shutdown();
	}
}
