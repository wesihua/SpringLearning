package com.wei.thread.proAndConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsStore {

	private static int MAX_SIZE = 10;
	private List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	/**
	 * 生产方法
	 */
	public synchronized void produce(){
		System.out.println(Thread.currentThread().getName()+"开始生产...");
		//如果当前数量大于最大库存则等待
		while(list.size() > MAX_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//否则正常生产
		list.add("xx");
		System.out.println(Thread.currentThread().getName()+"生产结束，仓库中剩余："+list.size());
		//唤醒所有等待的线程
		notifyAll();
		
		
	}
	/**
	 * 消费方法
	 */
	public synchronized void consumer(){
		System.out.println(Thread.currentThread().getName()+"开始消费...");
		//如果库存为0则等待
		while(list.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//否则开始消费
		list.remove(list.size()-1);
		System.out.println(Thread.currentThread().getName()+"消费结束，仓库中剩余："+list.size());
		//唤醒所有等待的线程
		notifyAll();
				
		
	}
}
