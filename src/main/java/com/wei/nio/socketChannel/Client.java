package com.wei.nio.socketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Client {

	public void client() {
		ByteBuffer buff = ByteBuffer.allocate(1024);
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress("localhost", 8080));
			if(socketChannel.finishConnect()) {
				int i = 1;
				while(true) {
					TimeUnit.SECONDS.sleep(1);
					String info = "I'm "+i+++"-th information from client";
					buff.clear();
					buff.put(info.getBytes());
					buff.flip();
					while(buff.hasRemaining()) {
						System.out.println(buff);
						socketChannel.write(buff);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(socketChannel != null) {
					socketChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.client();
	}
}
