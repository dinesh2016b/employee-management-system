package com.online.ems.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.exception.ResourceNotFoundException;

@FeignClient(name = "backend-department-service", url = "localhost:8091")
@RibbonClient(name = "backend-department-service")
public interface DepartmentServiceProxy {

	@GetMapping(path = "/departments/pageNo/{pageNo}/size/{size}")
	public List<DepartmentsBean> getAllDepartments(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception;

	@GetMapping(path = "/departments/{id}")
	public DepartmentsBean getDepartmentsById(@PathVariable(value = "id") String departmentId) throws Exception;

	@PostMapping(path = "/departments")
	public DepartmentsBean createDepartment(@RequestBody DepartmentsBean department) throws Exception;

	@PutMapping(path = "/departments/{deptId}")
	public DepartmentsBean updateDepartment(@PathVariable(value = "deptId") String departmentId,
			@RequestBody DepartmentsBean departmentsBean) throws ResourceNotFoundException;

	@DeleteMapping(path = "/departments/{deptId}")
	public Map<String, Boolean> deleteDepartment(@PathVariable(value = "deptId") String departmentId)
			throws ResourceNotFoundException;
}
