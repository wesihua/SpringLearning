package com.wei.singleton;

/**
 * ����ʽ����ģʽ
 * @author weish
 *
 */
public class LazySingleton {

	//˽�л��Ĺ��캯��
	private LazySingleton(){}
	
	//˽�л��ı���
	private static LazySingleton single = null;
	
	/**
	 * �������ģʽ
	 * ȱ���ǣ��޷������̰߳�ȫ
	 * @return
	 */
	public static LazySingleton getInstance(){
		if(null == null){
			single = new LazySingleton();
		}
		return single;
	}
	
	/**
	 * ����ʽ�Ľ�����1
	 * ȱ�㣺�����������̰߳�ȫ�����ǲ���������ܡ���Ϊÿ���̶߳��������ġ�
	 */
	public static synchronized LazySingleton getInstance_1(){
		if(null == single){
			single = new LazySingleton();
		}
		return single;
	}
	
	/**
	 * ����ʽ�Ľ�����2��˫�ؼ��������
	 * ֻ�ǵ�һ�ε�ʱ���߳��������Ժ�ÿ�ζ���ֱ��ȡֵ�����������̰߳�ȫ
	 * �ּ��������
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
	 * ����ʽ�Ľ�����3����̬�ڲ��ࡿ
	 * �ȱ�֤���̰߳�ȫ�ּ��������-�Ƽ�
	 * 
	 * ��Ϊ�����ʱ����Զ��������ڲ����instance��û�б�¶����ı�����Ҳ��û���˶��̵߳������ˡ�
	 * ͬʱҲû�����ܵ��ǡ��˷������ƶ���ʽ
	 */
	private static class LazyHolder{
		private static final LazySingleton INSTANCE = new LazySingleton();
	}
	
	public static LazySingleton getInstance_3(){
		return LazyHolder.INSTANCE;
	}
}
