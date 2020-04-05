package com.online.ems.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
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
@CrossOrigin(origins = "https://localhost:8080")
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

		logger.info("------------> getEmployees()");

		Resource<EmployeesBean> employesResource = null;
		List<Resource<EmployeesBean>> employeesResourceList = new ArrayList<Resource<EmployeesBean>>();

		try {

			List<Resource<EmployeesBean>> employeesBeans = employeeServiceProxy.getEmployees(pageNo, size);

			for (Resource<EmployeesBean> employeesBean : employeesBeans) {

				// employesResource = new Resource<EmployeesBean>(employeesBean);
				// employesResource
				// .add(linkTo(methodOn(EmployeesController.class).getEmployeeById(employeesBean.getEmpNo()))
				// .withRel("_self"));

				employeesResourceList.add(employeesBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return employeesResourceList;
	}

	@GetMapping(path = "/{id}")
	public Resource<EmployeesBean> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {

		try {

			Resource<EmployeesBean> employesResource = employeeServiceProxy.getEmployeeById(employeeId);

			String departmentId = "1002";
			DepartmentsBean departmentsBean = departmentServiceProxy.getDepartmentsById(departmentId);
			logger.debug("---------> Departments :" + departmentsBean);

			employesResource.getContent().setDepartmentsBean(departmentsBean);

			return employesResource;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<EmployeesBean> addEmployee(@RequestBody EmployeesBean employeesBean) throws Exception {

		logger.debug("--------> addEmployee() :" + employeesBean.toString());
		Resource<EmployeesBean> employesResource = null;
		try {

			employeeServiceProxy.addEmployee(employeesBean);

			employesResource = new Resource<EmployeesBean>(employeesBean);
			employesResource.add(linkTo(methodOn(EMSEmployeesController.class).getEmployees(0, 10)).withRel("_self"));

			return employesResource;

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return employesResource;

		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		 * .buildAndExpand(employeesBean.getEmpNo()).toUri();
		 */	}
}