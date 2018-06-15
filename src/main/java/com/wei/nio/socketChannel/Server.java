package com.wei.nio.socketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {

	private static final int BUF_SIZE=1024;
    private static final int PORT = 8080;
    private static final int TIMEOUT = 2000;
    
    public static void main(String[] args) {
		new Server().selector();
	}
    
	public void selector() {
		Selector selector = null;
		ServerSocketChannel ssChannel = null;
		try {
			selector = Selector.open();
			ssChannel = ServerSocketChannel.open();
			ssChannel.socket().bind(new InetSocketAddress(PORT));
			ssChannel.configureBlocking(false);
			ssChannel.register(selector, SelectionKey.OP_ACCEPT);
			while(true) {
				if(selector.select(TIMEOUT) == 0) {
					System.out.println("等待连接...");
					continue;
				}
				Iterator<SelectionKey> it = selector.selectedKeys().iterator();
				while(it.hasNext()) {
					SelectionKey key = it.next();
					if(key.isAcceptable()) {
						handleAccept(key);
					}
					if(key.isReadable()) {
						handleRead(key);
					}
					if(key.isWritable() && key.isValid()) {
						handleWrite(key);
					}
					if(key.isConnectable()) {
						System.out.println("isConnectable == true");
					}
					it.remove();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(selector != null) {
					selector.close();
				}
				if(ssChannel != null) {
					ssChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void handleAccept(SelectionKey key) throws IOException {
		ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
		SocketChannel channel = ssChannel.accept();
		channel.configureBlocking(false);
		channel.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(BUF_SIZE));
	}
	
	public static void handleRead(SelectionKey key) throws Exception {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buff = (ByteBuffer) key.attachment();
		int byteRead = channel.read(buff);
		while(byteRead > 0) {
			buff.flip();
			while(buff.hasRemaining()) {
				System.out.print((char)buff.get());
			}
			System.out.println();
			buff.clear();
			byteRead = channel.read(buff);
		}
		if(byteRead == -1) {
			channel.close();
		}
	}
	
	public static void handleWrite(SelectionKey key) throws Exception {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buff = (ByteBuffer) key.attachment();
		buff.flip();
		while(buff.hasRemaining()) {
			channel.write(buff);
		}
		buff.compact();
	}
}
