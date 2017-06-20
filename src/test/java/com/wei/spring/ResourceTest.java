package com.wei.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wei.spring.resource.ResourceLoaderImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:app-context.xml")
public class ResourceTest {

	@Autowired
	private ResourceLoaderImpl resourceLoaderImpl;
	
	@Test
	public void testResourceLoader(){
		String result = resourceLoaderImpl.showResource();
		System.out.println(result);
	}
}
