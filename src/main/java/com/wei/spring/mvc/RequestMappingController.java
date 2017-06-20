package com.wei.spring.mvc;

import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 各种requestMapping测试
 * @author weisihua
 *
 */

@RestController
@RequestMapping("controller")
public class RequestMappingController {

	private static Logger log = LoggerFactory.getLogger(RequestMappingController.class);
	
	/**
	 * controller中的ModelAttribute，在requestMapping之前执行
	 * @param model
	 */
	@ModelAttribute
	public void testModelAttribute(Model model){
		log.info("this modelAttribute in Controller, and the model is [ "+model+" ]");
		
	}
	
	/**
	 * 测试pathVariable
	 * @param userId
	 * @param model
	 * @return
	 */
	@RequestMapping(path="pathVariable/{userId}",produces="text/html;charset=utf-8")
	public String pathVariable(@PathVariable String userId,Model model){
		String result = "返回的结果是："+userId;
		//获取model中的属性
		Map<String,Object> map = model.asMap();
		for(Map.Entry<String, Object> entry : map.entrySet()){
			result+=entry.getKey()+"----"+entry.getValue();
		}
		return result;
	}
	
	/**
	 * 可惜现在没有cookie
	 * @param sessionId
	 * @return
	 */
	@RequestMapping(path="cookieValue",produces="text/html;charset=utf-8")
	public String cookieValue(@CookieValue("JSESSIONID") String sessionId){
		return "sessionId的值为："+sessionId;
	}
	
	/**
	 * 测试requestHeader【单个值】
	 * @param userAgent
	 * @param accept
	 * @return
	 */
	@RequestMapping(path="requestHeader",produces="text/html;charset=utf-8")
	public String requestHeader(@RequestHeader("User-Agent") String userAgent,@RequestHeader("Accept") String accept){
		String str = "userAgent的值为："+userAgent+"<br/>";
		str+= "accept的值为："+accept;
		return str;
	}
	
	/**
	 * 测试requestHeader【多个值】
	 * @param userAgent
	 * @param accept
	 * @return
	 */
	@RequestMapping(path="requestHeaderMultiValue",produces="text/html;charset=utf-8")
	public String requestHeaderMultiValue(@RequestHeader Map<String,String> map){
		String str = "以下为requestHeader的值：<br/>";
		if(null != map){
			for(Map.Entry<String, String> entry : map.entrySet()){
				str += entry.getKey()+"---->"+entry.getValue()+"<br/>";
			}
		}
		return str;
	}
	
	/**
	 * 验证@ExceptionHandler的拦截
	 * @return
	 */
	@RequestMapping(value="exception",produces="text/html;charset=utf-8")
	public String testException(){
		throw new RuntimeException("不好意思，我要报错了");
	}
	
	/**
	 * 验证时间格式转换
	 * @param birthday
	 * @return
	 */
	@RequestMapping(value="testDate",produces="text/html;charset=utf-8")
	public String testDate(@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date birthday){
		return birthday.toString();
	}
}
