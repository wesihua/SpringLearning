package com.wei.innerClass;

import com.wei.innerClass.OutterClass.NormalInnerClass;
import com.wei.innerClass.OutterClass.StaticInnerClass;

public class OutterClassDemo {

	public static void main(String[] args) {
		
		OutterClass outter = new OutterClass();
		NormalInnerClass normalInner = outter.getNormalInnerClass();
		StaticInnerClass staticInner = outter.getStaticInnerClass();
		//��ȡ����˽���ڲ���
		
		normalInner.display();
		staticInner.display();
		
		//��ȡ�ⲿ��
		OutterClass outter2 = normalInner.getOutterClass();
		outter2.print();
	}
}
