package com.wei.normal.abstractCls;


/**
 * 含有抽象方法的类叫抽象类，如果有抽象方法，则类必须声明为abstract
 * 即使不包括任何abstract 方法，亦可将一个类声明成“抽象类”。如果一个类没必要拥有任何抽象方法，而
 * 且我们想禁止那个类的所有实例，这种能力就会显得非常有用。
 * @author weisihua
 * @date 2017年10月19日
 */
public abstract class Father {

	public abstract void say();
	
	public abstract void eat();
}
