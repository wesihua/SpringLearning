package com.wei.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlAspect {

	private static Logger log = LoggerFactory.getLogger(XmlAspect.class);
	
	public void testBefore(){
		log.info("����xml-based�� before advice");
	}
	
	public void testAfterReturning(Object ret){
		log.info("����xml-based�� AfterReturning advice ���ҷ���ֵ�ǣ�"+ret);
	}
	
	public void testAfter(){
		log.info("����xml-based�� After advice game over");
	}
}
