package com.wei.thread.synchronize;

public class User {

	private int cash;
	
	public synchronized void operate(int count){
		this.cash += count;
		System.out.println(Thread.currentThread().getName() +"���н��������ӡ�" + count +"������ǰ�û��˻����Ϊ��" + cash);
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
	
}
