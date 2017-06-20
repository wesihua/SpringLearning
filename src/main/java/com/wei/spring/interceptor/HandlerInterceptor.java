package com.wei.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * requestHandler À¹½ØÆ÷
 * @author Administrator
 *
 */
public class HandlerInterceptor extends HandlerInterceptorAdapter {

	private Logger log = LoggerFactory.getLogger(HandlerInterceptor.class);
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		log.info("¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡· ½øÈëÀ¹½ØÆ÷: preHandle ¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·¡·");
		log.info("handlerµÄÃû³ÆÊÇ£º"+handler.getClass().getName());
		return true;
	}
	
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		log.info("¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶ ÍË³öÀ¹½ØÆ÷: postHandle ¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶¡¶");
	}
}
