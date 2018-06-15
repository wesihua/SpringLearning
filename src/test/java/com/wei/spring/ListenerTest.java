package com.wei.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wei.spring.listener.ContentEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:app-context.xml")
public class ListenerTest {

	@Autowired
	private ApplicationContext ctx;
	
	@Test
	public void testEvent() {
		ctx.publishEvent(new ContentEvent("请相关人等到广场开会。"));
	}
	
}
