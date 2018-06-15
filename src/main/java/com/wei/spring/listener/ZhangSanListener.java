package com.wei.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ZhangSanListener implements ApplicationListener<ContentEvent> {

	@Override
	public void onApplicationEvent(ContentEvent event) {
		// TODO Auto-generated method stub
		System.out.println("张三收到了广播："+ event.getSource());
	}

}
