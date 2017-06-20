package com.wei.thread.synchronize;

public class User {

	private int cash;
	
	public synchronized void operate(int count){
		this.cash += count;
		System.out.println(Thread.currentThread().getName() +"运行结束，增加“" + count +"”，当前用户账户余额为：" + cash);
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
	
}
