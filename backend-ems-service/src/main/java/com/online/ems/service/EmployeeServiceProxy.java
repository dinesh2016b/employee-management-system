package com.online.ems.service;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.ems.bean.EmployeesBean;

@FeignClient(name = "backend-employee-service", url = "localhost:8092")
@RibbonClient(name = "backend-employee-service")
public interface EmployeeServiceProxy {

	@GetMapping(path = "/backend-employee-service/employees/pageNo/{pageNo}/size/{size}")
	public List<Resource<EmployeesBean>> getEmployees(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception;

	@GetMapping(path = "/backend-employee-service/employees/{id}")
	public Resource<EmployeesBean> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception;

	@PostMapping(path = "/backend-employee-service/employees")
	public Resource<EmployeesBean> addEmployee(@RequestBody EmployeesBean employeesBean) throws Exception;
}
