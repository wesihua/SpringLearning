package com.wei.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProAndCons {

	private String[] array = new String[10];
	int takeIndex,putIndex,count;
	Lock lock = new ReentrantLock();
	Condition notFull = lock.newCondition(); // 写线程锁
	Condition notEmpty = lock.newCondition(); // 读线程锁
	
	/**
	 * 消费
	 * @return
	 */
	public String get() {
		lock.lock();
		String result = null;
		try {
			if(array.length == 0) {
				// 读操作等待
				notEmpty.await();
			}
			result = array[takeIndex];
			// 超过限制，则置0
			if(++takeIndex == array.length) {
				takeIndex = 0;
			}
			--count;
			// 唤醒写操作
			notFull.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
		return result;
	}
	
	/**
	 * 生产
	 */
	public void put() {
		lock.lock();
		try {
			if(count == array.length) {
				// 写线程等待
				notFull.await();
			}
			array[putIndex] = "hello world";
			if(++putIndex == array.length) {
				putIndex = 0;
			}
			++count;
			// 唤醒读线程
			notEmpty.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			lock.unlock();
		}
	}
	
}
