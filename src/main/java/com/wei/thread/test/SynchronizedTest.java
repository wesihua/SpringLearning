package com.wei.thread.test;

import com.wei.thread.synchronize.MyThread;
import com.wei.thread.synchronize.User;

public class SynchronizedTest {

	public static void main(String[] args) {
		User u = new User();
		MyThread t1 = new MyThread("�߳�1",u,10);
		MyThread t2 = new MyThread("�߳�2",u,-20);
		MyThread t3 = new MyThread("�߳�3",u,100);
		MyThread t4 = new MyThread("�߳�4",u,50);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
