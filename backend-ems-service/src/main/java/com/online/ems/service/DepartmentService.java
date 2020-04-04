package com.online.ems.service;

import java.util.List;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.exception.ResourceNotFoundException;

public interface DepartmentService {

	public List<DepartmentsBean> getAllDepartments() throws Exception;

	public DepartmentsBean getDepartmentsById(String departmentId) throws Exception;

	public DepartmentsBean createDepartment(DepartmentsBean departmentsBean) throws ResourceNotFoundException;

	public DepartmentsBean updateEmployee(String departmentId, DepartmentsBean departmentsBean)
			throws ResourceNotFoundException;

	public int deleteDepartment(String departmentId) throws ResourceNotFoundException;
}
