package com.wei.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@org.springframework.context.annotation.PropertySource("classpath:app.properties")
public class PropertySource {

	@Autowired
	private Environment evi;
	
	@Override
	public String toString() {
		return "����propertySource�Ĳ��ԣ� ���ԣ�property.test��ֵ�ǣ�"+evi.getProperty("property.test");
	}
}
