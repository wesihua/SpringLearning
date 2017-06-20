package com.wei.innerClass;

public class OutterClass {

	private int age = 20;
	private static String name = "zhangjuanjuan";
	
	//普通内部类
	public class NormalInnerClass{
		
		private String name = "weisihua";
		
		public void display(){
			System.out.println("the name is [ "+name+" ] and the age is [ "+age+" ]");
		}
		
		//获取外部对象
		public OutterClass getOutterClass(){
			return OutterClass.this;
		}
	} 
	//静态内部类
	public static class StaticInnerClass{
		public void display(){
			System.out.println("the name is [ "+name+" ]");
		}
	}
	
	//私有内部类
	private class PrivateInnerClass{
		private int height = 180;
		
		public void display(){
			System.out.println("the name is [ "+name+" ] and the height is [ "+height+" ]");
		}
	}
	
	//获取内部类实例
	public NormalInnerClass getNormalInnerClass(){
		
		return new OutterClass().new NormalInnerClass();
	}
	
	public StaticInnerClass getStaticInnerClass(){
		
		//return new StaticInnerClass();
		//或
		return new OutterClass.StaticInnerClass();
	}
	
	public PrivateInnerClass getPrivateInnerClass(){
		
		return new PrivateInnerClass();
		//或
		//return new OutterClass.PrivateInnerClass();
	}
	
	
	public void print(){
		System.out.println("我是外部类的普通方法");
	}
	public static void main(String[] args) {
		
		OutterClass outter = new OutterClass();
		outter.getNormalInnerClass().display();
		outter.getStaticInnerClass().display();
		outter.getPrivateInnerClass().display();
	}
}
