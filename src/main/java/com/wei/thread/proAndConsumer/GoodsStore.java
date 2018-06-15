package com.wei.thread.proAndConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsStore {

	private static int MAX_SIZE = 10;
	private List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	/**
	 * 生产
	 */
	public synchronized void produce(){
		System.out.println(Thread.currentThread().getName()+"开始生产...");
		//当超过最大容量，则等待
		if(list.size() > MAX_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//否则开始生产
		list.add("xx");
		System.out.println(Thread.currentThread().getName()+"生产完成，当前容量是："+list.size());
		//唤醒等待中的消费者线程开始消费
		notifyAll();
		
		
	}
	/**
	 * 消费
	 */
	public synchronized void consumer(){
		System.out.println(Thread.currentThread().getName()+"开始消费...");
		//当容量为空时，停止消费
		if(list.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//否则开始消费
		list.remove(list.size()-1);
		System.out.println(Thread.currentThread().getName()+"消费完成，当前容量为："+list.size());
		//唤醒等待的生产者线程开始生产
		notifyAll();
				
		
	}
}
