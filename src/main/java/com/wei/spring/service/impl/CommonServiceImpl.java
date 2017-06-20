package com.wei.spring.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.wei.spring.service.ICommonService;

@Service("commonService")
public class CommonServiceImpl implements ICommonService {

	private static Logger log = LoggerFactory.getLogger(CommonServiceImpl.class);
	
	@Override
	public void insertSomething() {
		// TODO Auto-generated method stub
		log.info("我新增了一条数据");
	}

}
