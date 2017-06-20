package com.wei.thread.proAndConsumer;

public class ConsumerThread extends Thread {

private GoodsStore store;
	
	public ConsumerThread(String name,GoodsStore store){
		super(name);
		this.store = store;
	}

	@Override
	public void run() {
		while(true){
			store.consumer();
		}
	}
}
