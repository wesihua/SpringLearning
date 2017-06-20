package com.wei.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

	private static int x;
	
	private List<String> nameList = Collections.synchronizedList(new ArrayList<String>());
	
	//验证线程安全类未必线程安全
	/**
	 * 因为方法上没加synchronized 所以尽管list是线程安全的。但是该类不是线程安全的。add()和removeFirst()可以同时有
	 * 多个线程进行操作。所以两个线程的操作就会造成数据错误。
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
	
	//静态和非静态方法的同步写法
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
