package com.wei.spring.advice;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wei.spring.bean.Person;

@ControllerAdvice
public class MyControllerAdvice {

	private static Logger log = LoggerFactory.getLogger(MyControllerAdvice.class);
	
//	/**
//	 * 向model中加入单个值，在controller之前执行
//	 * @param name
//	 * @return
//	 */
//	@ModelAttribute("myName")
//	public String addName(@RequestParam String name){
//		log.info("this is the first modelAttribute, and the parameter name is : " + name);
//		return name;
//	}
	
	/**
	 * 向model中加入多个值，在controller之前执行
	 * @param model
	 */
	@ModelAttribute
	public void addOther(Model model){
		log.info("this is the second modelAttribute");
		Person p = new Person();
		p.setAge(30);
		p.setBirthday(new Date());
		p.setName("魏四化");
		model.addAttribute("person", p);
	}
	
	/**
	 * 请求中的统一的异常处理
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler
	public String handleException(Exception ex){
		return "the exception is : " + ex.toString();
	}
}
