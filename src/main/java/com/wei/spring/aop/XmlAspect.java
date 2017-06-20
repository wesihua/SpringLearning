package com.wei.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlAspect {

	private static Logger log = LoggerFactory.getLogger(XmlAspect.class);
	
	public void testBefore(){
		log.info("我是xml-based的 before advice");
	}
	
	public void testAfterReturning(Object ret){
		log.info("我是xml-based的 AfterReturning advice 并且返回值是："+ret);
	}
	
	public void testAfter(){
		log.info("我是xml-based的 After advice game over");
	}
}
