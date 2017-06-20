package com.wei.spring.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wei.spring.bean.BlackDog;
import com.wei.spring.bean.IDog;

public class MyInvocationHandler implements InvocationHandler {

	private IDog dog;
	
	public MyInvocationHandler(IDog dog){
		this.dog = dog;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object obj = null;
		System.out.println("���������������������ڷ�������֮ǰִ�е�");
		obj = method.invoke(dog, args);
		System.out.println("ִ�к�Ľ���ǣ�"+obj);
		System.out.println("���������������������ڷ�������֮��ִ�е�");
		return obj;
	}

	public IDog getDog() {
		return dog;
	}

	public void setDog(IDog dog) {
		this.dog = dog;
	}

	public static void main(String[] args) {
		IDog dog = new BlackDog();
		
		IDog d = (IDog) Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), new MyInvocationHandler(dog));
		d.bark("�Ƴ���");
		d.sayName("�Ƴ���");
	}
}
