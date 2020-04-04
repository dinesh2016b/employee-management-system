/**
 * 
 */
package com.online.ems.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.service.DepartmentService;

/**
 * @author dinesh
 *
 */

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Override
	public List<DepartmentsBean> getAllDepartments() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentsBean getDepartmentsById(String departmentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentsBean createDepartment(DepartmentsBean departmentsBean)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentsBean updateEmployee(String departmentId, DepartmentsBean departmentsBean)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteDepartment(String departmentId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

}
