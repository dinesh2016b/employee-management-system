package com.online.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.online.ems.bean.EmployeesBean;
import com.online.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public List<EmployeesBean> getEmployees(int firstRecord, int size) throws Exception {

		List<EmployeesBean> employeesBeans = new ArrayList<EmployeesBean>();
		logger.debug("------------> getEmployees() : " + employeesBeans);

		return employeesBeans;
	}

	public EmployeesBean getEmployeesById(Long employeeId) throws Exception {

		EmployeesBean employeesBean = null;
		logger.debug("------------> getEmployeesById() : " + employeesBean.toString());

		return employeesBean;
	}

	public void addEmployee(EmployeesBean employeesBean) throws Exception {

		logger.debug("------------> getEmployeesById() : " + employeesBean.toString());
		
	}
}
