package com.wei.thread.typicalProducerAndConsumer;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import com.wei.spring.bean.Person;

public class Producer implements Runnable {

	//��������
	private final BlockingQueue<Person> queue;
	
	public Producer(BlockingQueue<Person> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		System.out.println("��ʼ����...");
		try {
			while(true){
				queue.put(produce());
				System.out.println("������  " +queue.size()+ " ����Ʒ");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * ��������
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
