package com.wei.thread;

public class JoinThread extends Thread {

	@Override
	public void run() {
		System.out.println("�̣߳�"+Thread.currentThread().getName()+"��ʼִ��");
		for(int i=0; i < 5; i++){
			System.out.println("�߳�"+Thread.currentThread().getName()+"ִ�У�"+i+"s");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("�̣߳�"+Thread.currentThread().getName()+"ִ�н���");
	}
	
	public static void main(String[] args) throws InterruptedException {
		JoinThread t = new JoinThread();
		MyThread t1 = new MyThread("�����ź�");
		System.out.println("==�̣߳�"+Thread.currentThread().getName()+"��ʼִ��==");
		t.start();
		t1.start();
		t.join();//tִ����֮��Ż�ִ�����һ���ӡ��main��,��t1����Ӱ��
		System.out.println("==�̣߳�"+Thread.currentThread().getName()+"ִ�н���==");
	}
}
