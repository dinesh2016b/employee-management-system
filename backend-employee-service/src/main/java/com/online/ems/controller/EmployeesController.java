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
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.ems.bean.EmployeesBean;
import com.online.ems.service.EmployeeService;

@RestController
@CrossOrigin(origins = "https://localhost:8080")
@RequestMapping("/employees")
public class EmployeesController {

	private final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/pageNo/{pageNo}/size/{size}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Resource<EmployeesBean>> getEmployees(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception {

		logger.info("------------> getEmployees()");

		Resource<EmployeesBean> employesResource = null;
		List<Resource<EmployeesBean>> employeesResourceList = new ArrayList<Resource<EmployeesBean>>();

		try {
			List<EmployeesBean> employeesBeans = employeeService.getEmployees(pageNo, size);

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

		return employeesResourceList;
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Resource<EmployeesBean> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws Exception {

		Resource<EmployeesBean> employesResource = null;
		try {

			//restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("dinesh", "dinesh"));
			//DepartmentsBean departmentsBean = (DepartmentsBean) restTemplate
			//		.getForObject("http://localhost:8091/departments/d001", DepartmentsBean.class);

			//logger.debug("---------> Departments :" + departmentsBean);

			EmployeesBean employeesBean = employeeService.getEmployeesById(employeeId);
			//employeesBean.setDepartmentsBean(departmentsBean);

			employesResource = new Resource<EmployeesBean>(employeesBean);
			employesResource.add(linkTo(methodOn(EmployeesController.class).getEmployees(0, 10)).withRel("_self"));

			return employesResource;
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

		return null;
	}

	@PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
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