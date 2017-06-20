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
		System.out.println("��ʼ����...");
		try {
			while(true){
				consume(queue.take());
				System.out.println("������ɣ���ʣ  "+queue.size()+ " ����Ʒ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void consume(Person p){
		
	}
}
