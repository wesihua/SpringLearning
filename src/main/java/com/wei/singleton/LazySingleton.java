package com.wei.singleton;

/**
 * 懒汉式单例模式
 * @author weish
 *
 */
public class LazySingleton {

	//私有化的构造函数
	private LazySingleton(){}
	
	//私有化的变量
	private static LazySingleton single = null;
	
	/**
	 * 最基本的模式
	 * 缺点是：无法做到线程安全
	 * @return
	 */
	public static LazySingleton getInstance(){
		if(null == null){
			single = new LazySingleton();
		}
		return single;
	}
	
	/**
	 * 懒汉式改进方法1
	 * 缺点：尽管满足了线程安全，但是不满足高性能。因为每个线程都是阻塞的。
	 */
	public static synchronized LazySingleton getInstance_1(){
		if(null == single){
			single = new LazySingleton();
		}
		return single;
	}
	
	/**
	 * 懒汉式改进方法2【双重检查锁定】
	 * 只是第一次的时候线程阻塞，以后每次都是直接取值。既满足了线程安全
	 * 又兼顾了性能
	 */
	public static LazySingleton getInstance_2(){
		if(null == single){
			synchronized (LazySingleton.class) {
				if(null == single){
					single = new LazySingleton();
				}
			}
		}
		return single;
	}
	
	/**
	 * 懒汉式改进方法3【静态内部类】
	 * 既保证了线程安全又兼顾了性能-推荐
	 * 
	 * 因为编译的时候就自动生成了内部类的instance。没有暴露在外的变量。也就没有了多线程的问题了。
	 * 同时也没有性能担忧。此方法类似饿汉式
	 */
	private static class LazyHolder{
		private static final LazySingleton INSTANCE = new LazySingleton();
	}
	
	public static LazySingleton getInstance_3(){
		return LazyHolder.INSTANCE;
	}
}
