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

/**
 * ����һЩ������
 * pointCut���﷨����Ϊ��
 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
 * @author Administrator
 *
 */
@Component
@Aspect
public class MyAspect {

	private static Logger log = LoggerFactory.getLogger(MyAspect.class);
	/**
	 * �������е� ����������insert��ͷ�ķ���
	 */
	@Pointcut("execution(* com.wei.spring.mvc..*.insert*(..))")
	public void insertMethod(){}
	
	/**
	 * ������ͨ��bean
	 */
	@Pointcut("execution(* com.wei.spring..*.*(..))")
	public void normalMethod(){}
	
	
	@Before("insertMethod()")
	public void printMessage1(JoinPoint jp){
		//��ȡ�������õ���Ϣ
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//��ȡ��ȡ�����б�
		Object[] args = jp.getArgs();//�и����ã��޷�֪��ȷ�е�����
		//��ȡ�����صĶ���
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController�Ĵ���
		
		log.info("���� Before ��ʲôҲû��");
	}
	
//	@Before("execution(* com.wei.spring..*.*(..))")
//	public void printMessage2(){
//		System.out.println("�����ڵڶ���pointCut");
//	}
	
	@AfterThrowing(pointcut="execution(* com.wei.spring.mvc..*.insert*(..))",throwing="ex")
	public void testAfterThrowing(Exception ex){
		log.info("���� AfterThrowing �����쳣Ϊ��"+ex.getMessage());
	}
	
	/**
	 * ��ƥ��� @AfterReturning
	 * @param jp
	 * @param ret
	 */
	@AfterReturning(pointcut="execution(* com.wei.spring.mvc..*.insert*(..))",returning="ret")
	public void testAfterReturning(JoinPoint jp,Object ret){
		//��ȡ�������õ���Ϣ
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//��ȡ��ȡ�����б�
		Object[] args = jp.getArgs();//�и����ã��޷�֪��ȷ�е�����
		//��ȡ�����صĶ���
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController�Ĵ���
		
		log.info("���� AfterReturning ����ִ�н��Ϊ��"+ret.toString()+"  �÷���Ϊ��"+msg);
	}
	
	/**
	 * ��ȷƥ��� @AfterReturning
	 * args ������������������1����ȷƥ�䣬2�����ݲ�����advice
	 * @param jp
	 * @param ret
	 * @param name
	 * @param age
	 */
	@AfterReturning(pointcut="execution(* com.wei.spring.mvc..*.insert*(..)) && args(name,age,..)",returning="ret")
	public void testAfterReturning(JoinPoint jp,Object ret,String name,int age){
		//��ȡ�������õ���Ϣ
		Signature sig = jp.getSignature();
		String msg = sig.toString();// String com.wei.spring.mvc.AopController.insertService2(String,Integer)
		//String declaringTypeName = sig.getDeclaringTypeName();// com.wei.spring.mvc.AopController
		String methodName = sig.getName();
		//��ȡ��ȡ�����б�
		Object[] args = jp.getArgs();//�и����ã��޷�֪��ȷ�е�����
		//��ȡ�����صĶ���
		Object obj = jp.getTarget();//AopController
		Object obj2 = jp.getThis();//AopController�Ĵ���
		
		log.info("���� AfterReturning����ȡ������ʽ1�� ����ִ�н��Ϊ��"+ret.toString()+"  �÷���Ϊ��"+methodName+"("+name+","+age+")");
	}
	
	
	/**
	 * after (finally)
	 * ��adviceִ������ AfterReturning �� AfterThrowing
	 * @param jp
	 */
	@After("execution(* com.wei.spring.mvc..*.insert*(..))")
	public void testAfater(JoinPoint jp){
		log.info("���� After �������˱�ʾ����ִ����ɣ�����");
	}
	
	
	@Around("execution(* com.wei.spring.mvc..*.insert*(..))")
	public Object testAround(ProceedingJoinPoint pjp) throws Throwable{
		
		log.info("����around��ǰ����");
		Object ret = pjp.proceed();
		log.info("����around�ĺ���");
		return ret;
	}
}
