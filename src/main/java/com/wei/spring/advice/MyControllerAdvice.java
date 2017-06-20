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
//	 * ��model�м��뵥��ֵ����controller֮ǰִ��
//	 * @param name
//	 * @return
//	 */
//	@ModelAttribute("myName")
//	public String addName(@RequestParam String name){
//		log.info("this is the first modelAttribute, and the parameter name is : " + name);
//		return name;
//	}
	
	/**
	 * ��model�м�����ֵ����controller֮ǰִ��
	 * @param model
	 */
	@ModelAttribute
	public void addOther(Model model){
		log.info("this is the second modelAttribute");
		Person p = new Person();
		p.setAge(30);
		p.setBirthday(new Date());
		p.setName("κ�Ļ�");
		model.addAttribute("person", p);
	}
	
	/**
	 * �����е�ͳһ���쳣����
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler
	public String handleException(Exception ex){
		return "the exception is : " + ex.toString();
	}
}
