package com.online.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.bean.EmployeesBean;
import com.online.ems.bean.SalariesBean;
import com.online.ems.dao.EmployeeRepository;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Employees;

@Service
public class EmployeeService {

	private final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private DepartmentServiceProxy departmentServiceProxy;
	
	@Autowired
	private SalariesServiceProxy salariesServiceProxy;

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeesBean> getEmployees(int firstRecord, int size) throws Exception {

		Pageable pageable = PageRequest.of(firstRecord, size);

		Page<Employees> employeeList = employeeRepository.findAll(pageable);

		List<EmployeesBean> employeesBeans = new ArrayList<EmployeesBean>();
		EmployeesBean employeesBean = null;
		for (Employees employees : employeeList) {
			employeesBean = new EmployeesBean();
			employeesBean.setEmpNo(employees.getEmpNo());
			employeesBean.setFirstName(employees.getFirstName());
			employeesBean.setLastName(employees.getLastName());
			employeesBean.setBirthDate(employees.getBirthDate());
			
			String departmentId = "1001";
			DepartmentsBean departmentsBean = departmentServiceProxy.getDepartmentsById(departmentId);
			logger.debug("---------> Departments :" + departmentsBean);
			
			employeesBean.setDepartmentsBean(departmentsBean);

			SalariesBean salariesBean = salariesServiceProxy.getSalariesByEmployeeId(employees.getEmpNo());
			employeesBean.setSalariesBean(salariesBean);

			logger.debug("------------> getEmployeesById() : " + employeesBean);

			employeesBeans.add(employeesBean);
		}

		logger.debug("------------> getEmployees() : " + employeeList);

		return employeesBeans;
	}

	public EmployeesBean getEmployeesById(Long employeeId) throws Exception {

		EmployeesBean employeesBean = null;
		Employees employees = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employees not found for this empNo :: " + employeeId));

		if (employees != null) {
			employeesBean = new EmployeesBean();
			employeesBean.setEmpNo(employees.getEmpNo());
			employeesBean.setFirstName(employees.getFirstName());
			employeesBean.setLastName(employees.getLastName());
			employeesBean.setBirthDate(employees.getBirthDate());
		}
		
		String departmentId = "1001";
		DepartmentsBean departmentsBean = departmentServiceProxy.getDepartmentsById(departmentId);
		logger.debug("---------> Departments :" + departmentsBean);
		
		employeesBean.setDepartmentsBean(departmentsBean);

		SalariesBean salariesBean = salariesServiceProxy.getSalariesByEmployeeId(employees.getEmpNo());
		employeesBean.setSalariesBean(salariesBean);

		logger.debug("------------> getEmployeesById() : " + employeesBean);

		return employeesBean;
	}

	public void addEmployee(EmployeesBean employeesBean) throws Exception {

		logger.debug("------------> getEmployeesById() : " + employeesBean.toString());
		
		Employees employees = new Employees();
		employees.setEmpNo(employeesBean.getEmpNo());
		employees.setFirstName(employeesBean.getFirstName());
		employees.setLastName(employeesBean.getLastName());
		employees.setBirthDate(employeesBean.getBirthDate());

		employeeRepository.save(employees);
	}
}
