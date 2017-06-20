package com.wei.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

	private static int x;
	
	private List<String> nameList = Collections.synchronizedList(new ArrayList<String>());
	
	//��֤�̰߳�ȫ��δ���̰߳�ȫ
	/**
	 * ��Ϊ������û��synchronized ���Ծ���list���̰߳�ȫ�ġ����Ǹ��಻���̰߳�ȫ�ġ�add()��removeFirst()����ͬʱ��
	 * ����߳̽��в��������������̵߳Ĳ����ͻ�������ݴ���
	 * @param str
	 */
	public void add(String str){
		nameList.add(str);
	}
	
	public String removeFirst(){
		if(nameList.size() == 0){
			return null;
		}
		return nameList.get(0);
	}
	
	//��̬�ͷǾ�̬������ͬ��д��
	public synchronized int getX() {
        return x;
    }
	
	public int getX2(){
		synchronized (this) {
			return x;
		}
	}
	
	public static synchronized int getX3(){
		return Demo.x;
	}
	
	public static int getX4(){
		synchronized (Demo.class) {
			return Demo.x;
		}
	}
	
}
