package com.wei.thread.typicalProducerAndConsumer;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import com.wei.spring.bean.Person;

public class Producer implements Runnable {

	//阻塞队列
	private final BlockingQueue<Person> queue;
	
	public Producer(BlockingQueue<Person> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("开始生产...");
		try {
			while(true){
				queue.put(produce());
				System.out.println("生产了  " +queue.size()+ " 个产品");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 生产方法
	 * @return
	 */
	public Person produce(){
		Person p = new Person();
		p.setAge(10);
		p.setBirthday(new Date());
		p.setName("weisihua");
		return p;
	}
}
