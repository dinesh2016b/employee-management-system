package com.online.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.ems.bean.EmployeesBean;
import com.online.ems.bean.SalariesBean;
import com.online.ems.service.SalariesServiceProxy;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ems-salaries")
public class EMSSalariesController {

	@Autowired
	private SalariesServiceProxy salariesServiceProxy;

	@GetMapping(path = "/{id}")
	public ResponseEntity<List<Resource<SalariesBean>>> getSalariesByEmployeeId(@PathVariable(value = "id") int id)
			throws Exception {

		logger.info("------------> getEmployees()");

		Resource<EmployeesBean> employesResource = null;
		List<Resource<SalariesBean>> employeesResourceList = new ArrayList<Resource<SalariesBean>>();

		try {
			SalariesBean salariesBean = salariesServiceProxy.getSalariesByEmployeeId(id);

			// employesResource = new Resource<EmployeesBean>(salariesBean);
			// employesResource.add(linkTo(methodOn(SalariesController.class).getEmployeeById(salariesBean.getEmployeesBean())
			// .withRel("_self"));

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return ResponseEntity.ok().body(employeesResourceList);
	}
}