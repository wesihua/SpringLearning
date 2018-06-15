package com.wei.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

	public void ByteBufferTest() {
		try {
			RandomAccessFile file = new RandomAccessFile("D:/浙江机构号.txt", "rw");
			FileChannel fileChannel = file.getChannel();
			ByteBuffer buff = ByteBuffer.allocate(1024);
			int byteRead = fileChannel.read(buff);
			while(byteRead != -1) {
				//System.out.println("Read "+byteRead);
				buff.flip();
				while(buff.hasRemaining()) {
					System.out.print((char)buff.get());
				}
				buff.clear();
				byteRead = fileChannel.read(buff);
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void CharBufferTest() {
		try {
			RandomAccessFile file = new RandomAccessFile("D:/浙江机构号.txt", "rw");
			//FileChannel fileChannel = file.getChannel();
			CharBuffer buff = CharBuffer.allocate(1024);
			buff.put("weisihua");
			buff.flip();
//			for(int i = 0; i < buff.limit(); i++) {
//				System.out.print(buff.get());
//			}
			while(buff.remaining() > 0) {
				System.out.print(buff.get());
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void transferFromTest() {
		try {
			RandomAccessFile fromFile = new RandomAccessFile("D:/from.txt", "rw");
			FileChannel fromChannel = fromFile.getChannel();
			RandomAccessFile toFile = new RandomAccessFile("D:/to.txt", "rw");
			FileChannel toChannel = toFile.getChannel();
			long position = 0;
			long count = fromChannel.size();
			toChannel.transferFrom(fromChannel, position, count);
			System.out.println("传输完成");
			fromFile.close();
			toFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void transferToTest() {
		try {
			RandomAccessFile fromFile = new RandomAccessFile("D:/from.txt", "rw");
			FileChannel fromChannel = fromFile.getChannel();
			RandomAccessFile toFile = new RandomAccessFile("D:/to.txt", "rw");
			FileChannel toChannel = toFile.getChannel();
			long position = 0;
			long count = fromChannel.size();
			//toChannel.transferFrom(fromChannel, position, count);
			fromChannel.transferTo(position, count, toChannel);
			System.out.println("传输完成");
			fromFile.close();
			toFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileChannelDemo d = new FileChannelDemo();
		//d.ByteBufferTest();
		//d.CharBufferTest();
		//d.transferFromTest();
		d.transferToTest();
	}
}
