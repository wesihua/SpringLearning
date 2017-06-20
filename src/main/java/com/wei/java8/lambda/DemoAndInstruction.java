package com.wei.java8.lambda;

public class DemoAndInstruction {

	/**
	1.Lambda���ʽ����ʽ����ʾ������ʾ

	Parameters -> an expression 
	2.���Lambda���ʽ��Ҫִ�ж������,��Ҫ�����������{}���а�װ������з���ֵ����Ҫ��ʾָ��return��䣬������ʾ:

	Parameters -> {expressions;};
	3.���Lambda���ʽ����Ҫ����������ʹ��һ�������ű�ʾ������ʾ����ʾ

	() -> {for (int i = 0; i < 1000; i++) doSomething();};
	4.Java��һ��ǿ���͵����ԣ���˲�������Ҫ�����ͣ�����������ܹ��Ʋ��Lambda���ʽ�Ĳ������ͣ�����Ҫ������ʾ�Ľ���ָ����������ʾ��
	��Java���Ʋ�Lambda���ʽ�Ĳ����������Ʋⷺ�����͵ķ����������ƣ�����Java����δ����͵ģ��˴���ȥ

	String []datas = new String[] {"peng","zhao","li"};
	Arrays.sort(datas,(String v1, String v2) -> Integer.compare(v1.length(), v2.length()));
	���������� ��ʾָ���˲�������Stirng����ʵ��ָ�������´�����ʾ��Ҳ�ǿ��Եģ���Ϊ�����������Lambda���ʽ��Ӧ�ĺ���ʽ�ӿ�Comparator<String>�����Զ��ƶ�

	String []datas = new String[] {"peng","zhao","li"};;
	Arrays.sort(datas,(v1, v2) -> Integer.compare(v1.length(), v2.length()));
	5.���Lambda���ʽֻ��һ�����������Ҳ����������ǿ����ɱ������ƶϳ����ģ������������ʾʹ��Lambda���ʽ,������ʡ�Բ��������ͼ�����

	Stream.of(datas).forEach(param -> {System.out.println(param.length());});
	6.Lambda���ʽ�ķ������ͣ�����ָ�����������������ƶϣ�˵�������ƶ�

	*/
	public static void main(String[] args) {
		//����һ���߳�
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("hello world");
			}
		}).start();
		
		//java8��ʽ
		new Thread(() -> System.out.println("hello java8")).start();
	}
}
