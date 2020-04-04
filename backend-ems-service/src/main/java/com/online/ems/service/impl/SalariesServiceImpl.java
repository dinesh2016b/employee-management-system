package com.online.ems.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.online.ems.bean.SalariesBean;
import com.online.ems.service.SalariesService;

@Service
public class SalariesServiceImpl implements SalariesService {

	private Logger logger = LoggerFactory.getLogger(SalariesService.class);

	@Override
	public SalariesBean getSalariesByEmployeeId(String departmentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}}
