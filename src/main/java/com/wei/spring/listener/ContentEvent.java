package com.wei.spring.listener;

import org.springframework.context.ApplicationEvent;
/**
 * 自定义事件
 * @author weisihua
 * @date 2017年10月9日
 */
public class ContentEvent extends ApplicationEvent {

	public ContentEvent(String source) {
		super(source);
	}

	private static final long serialVersionUID = 1L;

}
