package com.online.ems.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.ems.bean.EmployeesBean;
import com.online.ems.service.EmployeeService;

@RestController
@CrossOrigin(origins = "https://localhost:8080")

@RequestMapping("/ems-employees")
public class EmployeesController {

	private Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Resource<EmployeesBean>>> getEmployees() throws Exception {

		logger.info("------------> getEmployees()");

		Resource<EmployeesBean> employesResource = null;
		List<Resource<EmployeesBean>> employeesResourceList = new ArrayList<Resource<EmployeesBean>>();

		try {
			List<EmployeesBean> employeesBeans = employeeService.getEmployees(0, 10);

			for (EmployeesBean employeesBean : employeesBeans) {

				employesResource = new Resource<EmployeesBean>(employeesBean);
				employesResource
						.add(linkTo(methodOn(EmployeesController.class).getEmployeeById(employeesBean.getEmpNo()))
								.withRel("_self"));

				employeesResourceList.add(employesResource);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return ResponseEntity.ok().body(employeesResourceList);
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<EmployeesBean>> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws Exception {

		EmployeesBean employeesBean = employeeService.getEmployeesById(employeeId);

		Resource<EmployeesBean> employesResource = new Resource<EmployeesBean>(employeesBean);
		employesResource.add(linkTo(methodOn(EmployeesController.class).getEmployees()).withRel("_self"));

		return ResponseEntity.ok().body(employesResource);
	}

	@PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<EmployeesBean>> addEmployee(@RequestBody EmployeesBean employeesBean)
			throws Exception {

		logger.debug("--------> addEmployee() :" + employeesBean.toString()); 
		
		try {
			employeeService.addEmployee(employeesBean);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeesBean.getEmpNo()).toUri();

		return ResponseEntity.created(location).build();
	}
}