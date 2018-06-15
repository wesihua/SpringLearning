package com.wei.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LisiListener implements ApplicationListener<ContentEvent> {

	@Override
	public void onApplicationEvent(ContentEvent event) {
		// TODO Auto-generated method stub
		System.out.println("李四收到了广播："+ event.getSource());
	}

}
