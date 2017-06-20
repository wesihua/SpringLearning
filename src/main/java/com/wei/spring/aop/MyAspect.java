package com.wei.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.wei.spring.mvc.RequestMappingController;

/**
 * 定义一些拦截器
 * pointCut的语法规则为：
 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
 * @author Administrator
 *
 */
@Component
@Aspect
public class MyAspect {

	private static Logger log = LoggerFactory.getLogger(MyAspect.class);
	/**
	 * 拦截所有的 方法名称以insert开头的方法
	 */
	@Pointcut("execution(* com.wei.spring.mvc..*.insert*(..))")
	public void insertMethod(){}
	
	/**
	 * 拦截普通的bean
	 */
	@Pointcut("execution(* com.wei.spring..*.*(..))")
	public void normalMethod(){}
	
	
	@Before("insertMethod()")
	public void printMessage1(JoinPoint jp){
		//获取方法有用的信息
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//获取获取参数列表
		Object[] args = jp.getArgs();//有个卵用，无法知道确切的类型
		//获取被拦截的对象
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController的代理
		
		log.info("我是 Before 我什么也没做");
	}
	
//	@Before("execution(* com.wei.spring..*.*(..))")
//	public void printMessage2(){
//		System.out.println("我属于第二种pointCut");
//	}
	
	@AfterThrowing(pointcut="execution(* com.wei.spring.mvc..*.insert*(..))",throwing="ex")
	public void testAfterThrowing(Exception ex){
		log.info("我是 AfterThrowing 并且异常为："+ex.getMessage());
	}
	
	/**
	 * 简单匹配的 @AfterReturning
	 * @param jp
	 * @param ret
	 */
	@AfterReturning(pointcut="execution(* com.wei.spring.mvc..*.insert*(..))",returning="ret")
	public void testAfterReturning(JoinPoint jp,Object ret){
		//获取方法有用的信息
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//获取获取参数列表
		Object[] args = jp.getArgs();//有个卵用，无法知道确切的类型
		//获取被拦截的对象
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController的代理
		
		log.info("我是 AfterReturning 并且执行结果为："+ret.toString()+"  该方法为："+msg);
	}
	
	/**
	 * 精确匹配的 @AfterReturning
	 * args 参数的作用有两个：1：精确匹配，2：传递参数给advice
	 * @param jp
	 * @param ret
	 * @param name
	 * @param age
	 */
	@AfterReturning(pointcut="execution(* com.wei.spring.mvc..*.insert*(..)) && args(name,age,..)",returning="ret")
	public void testAfterReturning(JoinPoint jp,Object ret,String name,int age){
		//获取方法有用的信息
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//获取获取参数列表
		Object[] args = jp.getArgs();//有个卵用，无法知道确切的类型
		//获取被拦截的对象
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController的代理
		
		log.info("我是 AfterReturning【获取参数方式1】 并且执行结果为："+ret.toString()+"  该方法为："+methodName+"("+name+","+age+")");
	}
	
	
	/**
	 * after (finally)
	 * 该advice执行先于 AfterReturning 和 AfterThrowing
	 * @param jp
	 */
	@After("execution(* com.wei.spring.mvc..*.insert*(..))")
	public void testAfater(JoinPoint jp){
		log.info("我是 After 方法到此表示彻底执行完成！！！");
	}
	
	
	@Around("execution(* com.wei.spring.mvc..*.insert*(..))")
	public Object testAround(ProceedingJoinPoint pjp) throws Throwable{
		
		log.info("我是around的前步骤");
		Object ret = pjp.proceed();
		log.info("我是around的后步骤");
		return ret;
	}
}
