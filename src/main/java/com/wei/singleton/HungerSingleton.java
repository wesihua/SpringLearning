package com.wei.singleton;

/**
 * ����ʽ����
 * @author weish
 *
 */
public class HungerSingleton {

	//˽�л����캯��
	private HungerSingleton(){}
	
	//˽�л�����
	//������ֱ������ʵ�����ʲ������̰߳�ȫ����
	private static final HungerSingleton SINGLE = new HungerSingleton();
	
	/**
	 * ֱ�ӷ���ʵ��
	 * @return
	 */
	public static HungerSingleton getInstance(){
		return SINGLE;
	}
}
