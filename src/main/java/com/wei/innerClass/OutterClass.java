package com.wei.innerClass;

public class OutterClass {

	private int age = 20;
	private static String name = "zhangjuanjuan";
	
	//��ͨ�ڲ���
	public class NormalInnerClass{
		
		private String name = "weisihua";
		
		public void display(){
			System.out.println("the name is [ "+name+" ] and the age is [ "+age+" ]");
		}
		
		//��ȡ�ⲿ����
		public OutterClass getOutterClass(){
			return OutterClass.this;
		}
	} 
	//��̬�ڲ���
	public static class StaticInnerClass{
		public void display(){
			System.out.println("the name is [ "+name+" ]");
		}
	}
	
	//˽���ڲ���
	private class PrivateInnerClass{
		private int height = 180;
		
		public void display(){
			System.out.println("the name is [ "+name+" ] and the height is [ "+height+" ]");
		}
	}
	
	//��ȡ�ڲ���ʵ��
	public NormalInnerClass getNormalInnerClass(){
		
		return new OutterClass().new NormalInnerClass();
	}
	
	public StaticInnerClass getStaticInnerClass(){
		
		//return new StaticInnerClass();
		//��
		return new OutterClass.StaticInnerClass();
	}
	
	public PrivateInnerClass getPrivateInnerClass(){
		
		return new PrivateInnerClass();
		//��
		//return new OutterClass.PrivateInnerClass();
	}
	
	
	public void print(){
		System.out.println("�����ⲿ�����ͨ����");
	}
	public static void main(String[] args) {
		
		OutterClass outter = new OutterClass();
		outter.getNormalInnerClass().display();
		outter.getStaticInnerClass().display();
		outter.getPrivateInnerClass().display();
	}
}
