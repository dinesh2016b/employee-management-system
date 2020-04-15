package com.online.ems.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.bean.EmployeesBean;
import com.online.ems.service.DepartmentServiceProxy;
import com.online.ems.service.EmployeeServiceProxy;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ems-employees")
public class EMSEmployeesController {

	private Logger logger = LoggerFactory.getLogger(EMSEmployeesController.class);

	@Autowired
	private EmployeeServiceProxy employeeServiceProxy;

	@Autowired
	private DepartmentServiceProxy departmentServiceProxy;

	@GetMapping(path = "/pageNo/{pageNo}/size/{size}")
	public List<Resource<EmployeesBean>> getEmployees(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception {

		try {
			logger.debug("------------> getEmployees()");
			List<Resource<EmployeesBean>> employeesBeans = employeeServiceProxy.getEmployees(pageNo, size);
			return employeesBeans;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	@GetMapping(path = "/{id}")
	public Resource<EmployeesBean> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {

		try {
			logger.debug("---------> employeeServiceProxy.getEmployeeById() ");
			Resource<EmployeesBean> employesResource = employeeServiceProxy.getEmployeeById(employeeId);
			employesResource
					.add(linkTo(methodOn(EMSEmployeesController.class).getEmployeeById(employeeId)).withRel("_self"));

			/*
			String departmentId = "d001";
			DepartmentsBean departmentsBean = departmentServiceProxy.getDepartmentsById(departmentId);
			logger.debug("---------> Departments :" + departmentsBean);

			employesResource.getContent().setDepartmentsBean(departmentsBean);
			*/
			
			return employesResource;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<EmployeesBean> addEmployee(@RequestBody EmployeesBean employeesBean) throws Exception {

		Resource<EmployeesBean> employesResource = null;
		try {
			logger.debug("--------> addEmployee() :" + employeesBean.toString());

			employeeServiceProxy.addEmployee(employeesBean);
			employesResource = new Resource<EmployeesBean>(employeesBean);
			employesResource.add(linkTo(methodOn(EMSEmployeesController.class).getEmployees(0, 10)).withRel("_self"));

			return employesResource;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return employesResource;
	}
}