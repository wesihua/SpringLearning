package com.wei.thread.typicalProducerAndConsumer;

import java.util.concurrent.BlockingQueue;

import com.wei.spring.bean.Person;

public class Consumer implements Runnable {

	private BlockingQueue<Person> queue;
	
	public Consumer(BlockingQueue<Person> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("开始消费...");
		try {
			while(true){
				consume(queue.take());
				System.out.println("消费完成，还剩  "+queue.size()+ " 个产品");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void consume(Person p){
		
	}
}
