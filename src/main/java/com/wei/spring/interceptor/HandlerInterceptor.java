package com.wei.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * requestHandler ������
 * @author Administrator
 *
 */
public class HandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		log.info("���������������������������� ����������: preHandle ��������������������������");
		log.info("handler�������ǣ�"+handler.getClass().getName());
		return true;
	}
	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		log.info("���������������������������� �˳�������: postHandle ��������������������������");
	}
}
