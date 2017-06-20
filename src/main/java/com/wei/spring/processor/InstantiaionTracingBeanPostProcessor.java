package com.wei.spring.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InstantiaionTracingBeanPostProcessor implements BeanPostProcessor {

	private static Logger log = LoggerFactory.getLogger(BeanPostProcessor.class);
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		log.debug("--------> oh Bean ''" + beanName + "'' has bean created");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		//System.out.println("Bean ''" + beanName + "'' created : " + bean.toString());
		log.debug("--------> Bean ''" + beanName + "'' created : " + bean.toString());
		return bean;
	}

}
