package com.online.ems.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.online.ems.bean.DepartmentsBean;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.service.DepartmentServiceProxy;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ems-departments")
public class EMSDepartmentsController {

	private Logger logger = LoggerFactory.getLogger(EMSDepartmentsController.class);

	@Autowired
	private DepartmentServiceProxy departmentServiceProxy;

	@GetMapping(path = "/pageNo/{pageNo}/size/{size}")
	public List<DepartmentsBean> getAllDepartments(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception {
		try {
			logger.info("----> department list ");

			List<DepartmentsBean> departmentsBeanList = departmentServiceProxy.getAllDepartments(pageNo, size);

			return departmentsBeanList;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping(path = "/{id}")
	public DepartmentsBean getDepartmentsById(@PathVariable(value = "id") String departmentId) throws Exception {

		try {

			logger.info("----> departmentId - " + departmentId);
			DepartmentsBean departmentsBean = departmentServiceProxy.getDepartmentsById(departmentId);

			return departmentsBean;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping(path = "/")
	public ResponseEntity<DepartmentsBean> createDepartment(@Valid @RequestBody DepartmentsBean departmentBean)
			throws Exception {

		try {
			departmentServiceProxy.createDepartment(departmentBean);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(departmentBean.getDeptNo()).toUri();

			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PutMapping(path = "/{deptId}")
	public ResponseEntity<DepartmentsBean> updateEmployee(String departmentId, DepartmentsBean departmentsBean)
			throws ResourceNotFoundException {

		try {

			departmentServiceProxy.updateDepartment(departmentId, departmentsBean);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(departmentsBean.getDeptNo()).toUri();

			return ResponseEntity.created(location).build();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	@DeleteMapping(path = "/{deptId}")
	public Map<String, Boolean> deleteEmployee(String departmentId) throws ResourceNotFoundException {

		try {

			departmentServiceProxy.deleteDepartment(departmentId);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
}