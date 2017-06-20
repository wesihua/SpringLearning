package com.wei.innerClass;

import com.wei.innerClass.OutterClass.NormalInnerClass;
import com.wei.innerClass.OutterClass.StaticInnerClass;

public class OutterClassDemo {

	public static void main(String[] args) {
		
		OutterClass outter = new OutterClass();
		NormalInnerClass normalInner = outter.getNormalInnerClass();
		StaticInnerClass staticInner = outter.getStaticInnerClass();
		//获取不了私有内部类
		
		normalInner.display();
		staticInner.display();
		
		//获取外部类
		OutterClass outter2 = normalInner.getOutterClass();
		outter2.print();
	}
}
