package com.wei.thread.proAndConsumer;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
		GoodsStore store = new GoodsStore();
		Thread produce1 = new ProducerThread("producer1", store);
		Thread produce2 = new ProducerThread("producer2", store);
		Thread produce3 = new ProducerThread("producer3", store);
		Thread produce4 = new ProducerThread("producer4", store);
		
		Thread consumer1 = new ConsumerThread("consumer1", store);
		Thread consumer2 = new ConsumerThread("consumer2", store);
		Thread consumer3 = new ConsumerThread("consumer3", store);
		
		produce1.start();
		produce2.start();
		produce3.start();
		produce4.start();
		
		consumer1.start();
		consumer2.start();
		consumer3.start();
	}
}
