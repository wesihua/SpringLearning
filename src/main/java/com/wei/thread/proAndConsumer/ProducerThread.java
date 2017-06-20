package com.wei.thread.proAndConsumer;

public class ProducerThread extends Thread {

	private GoodsStore store;
	
	public ProducerThread(String name,GoodsStore store){
		super(name);
		this.store = store;
	}

	@Override
	public void run() {
		while(true){
			store.produce();
		}
	}
}
