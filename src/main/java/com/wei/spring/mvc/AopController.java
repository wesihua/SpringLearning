package com.wei.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wei.spring.service.ICommonService;

@RestController
@RequestMapping("aop")
public class AopController {

	@Autowired
	private ICommonService commonService;
	
	@RequestMapping(path="aopTest",produces="text/html;charset=utf-8")
	public void insertService(){
		commonService.insertSomething();
		throw new RuntimeException("空指针异常");
	}
	
	
	@RequestMapping(path="aopTest2",produces="text/html;charset=utf-8")
	public String insertService2(String name, Integer age){
		commonService.insertSomething();
		//throw new RuntimeException("空指针异常");
		String result = "我的名字是："+name+",我的年龄是："+age;
		return result;
	}
	
	@RequestMapping(path="aopTest3",produces="text/html;charset=utf-8")
	public String insertService3(){
		commonService.insertSomething();
		return "";
	}
}
