package com.wei.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wei.spring.resource.ResourceLoaderImpl3;

public class NormalWayTest {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		//ResourceLoaderImpl loader = (ResourceLoaderImpl) ctx.getBean("resourceLoaderImpl");
		//ResourceLoaderImpl2 loader = (ResourceLoaderImpl2) ctx.getBean("resourceLoaderImpl2");
		ResourceLoaderImpl3 loader = (ResourceLoaderImpl3) ctx.getBean("resourceLoaderImpl3");
		System.out.println(loader.showResource());
	}
	
//	public static void main(String[] args) {
//		String str = ",xxx,,,aaa";
//		String[] arr = str.split(",");
//		for(String a : arr){
//			System.out.println("xxxxx:"+a);
//		}
//		
//	}
}
