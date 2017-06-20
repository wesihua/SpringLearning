package com.wei.thread.proAndConsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsStore {

	private static int MAX_SIZE = 10;
	private List<String> list = Collections.synchronizedList(new ArrayList<String>());
	
	/**
	 * ��������
	 */
	public synchronized void produce(){
		System.out.println(Thread.currentThread().getName()+"��ʼ����...");
		//�����ǰ���������������ȴ�
		while(list.size() > MAX_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//������������
		list.add("xx");
		System.out.println(Thread.currentThread().getName()+"�����������ֿ���ʣ�ࣺ"+list.size());
		//�������еȴ����߳�
		notifyAll();
		
		
	}
	/**
	 * ���ѷ���
	 */
	public synchronized void consumer(){
		System.out.println(Thread.currentThread().getName()+"��ʼ����...");
		//������Ϊ0��ȴ�
		while(list.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//����ʼ����
		list.remove(list.size()-1);
		System.out.println(Thread.currentThread().getName()+"���ѽ������ֿ���ʣ�ࣺ"+list.size());
		//�������еȴ����߳�
		notifyAll();
				
		
	}
}
