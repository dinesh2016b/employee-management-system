package com.online.ems.service;

import java.util.List;

import com.online.ems.bean.EmployeesBean;

public interface EmployeeService {

	public List<EmployeesBean> getEmployees(int firstRecord, int size) throws Exception;

	public EmployeesBean getEmployeesById(Long employeeId) throws Exception;

	public void addEmployee(EmployeesBean employeesBean) throws Exception;
}
