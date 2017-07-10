package com.wei.singleton;

/**
 * 饿汉式单例
 * @author weish
 *
 */
public class HungerSingleton {

	//私有化构造函数
	private HungerSingleton(){}
	
	//私有化常量
	//编译期直接生成实例。故不存在线程安全问题
	private static final HungerSingleton SINGLE = new HungerSingleton();
	
	/**
	 * 直接返回实例
	 * @return
	 */
	public static HungerSingleton getInstance(){
		return SINGLE;
	}
}
