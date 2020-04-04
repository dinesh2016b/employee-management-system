package com.online.ems.service;

import com.online.ems.bean.SalariesBean;

public interface SalariesService {

	public SalariesBean getSalariesByEmployeeId(String departmentId) throws Exception;
}
