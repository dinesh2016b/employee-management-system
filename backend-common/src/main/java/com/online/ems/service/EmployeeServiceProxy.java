package com.online.ems.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.online.ems.bean.EmployeesBean;

//@FeignClient(name = "backend-employee-service", url = "localhost:8092")
//@FeignClient(name = "backend-employee-service")

@FeignClient(name = "backend-zuul-api-gateway-server")
public interface EmployeeServiceProxy {

	// @GetMapping(path = "/employees/pageNo/{pageNo}/size/{size}")
	@GetMapping(path = "/backend-employee-service/employees/pageNo/{pageNo}/size/{size}")
    List<EntityModel<EmployeesBean>> getEmployees(@PathVariable(value = "pageNo") int pageNo,
                                                  @PathVariable(value = "size") int size) throws Exception;

	// @GetMapping(path = "/employees/{id}")
	@GetMapping(path = "/backend-employee-service/employees/{id}")
    EntityModel<EmployeesBean> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception;

	// @PostMapping(path = "/employees")
	@PostMapping(path = "/backend-employee-service/employees")
    EntityModel<EmployeesBean> addEmployee(@RequestBody EmployeesBean employeesBean) throws Exception;
}
