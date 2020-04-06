package com.online.ems.controller;

import java.net.URI;
import java.util.ArrayList;
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
import com.online.ems.dao.DepartmentRepositoryDAO;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Departments;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/departments")
public class DepartmentController {

	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentRepositoryDAO departmentRepository;

	@GetMapping(path = "/pageNo/{pageNo}/size/{size}")
	public ResponseEntity<List<DepartmentsBean>> getAllDepartments(@PathVariable(value = "pageNo") int pageNo,
			@PathVariable(value = "size") int size) throws Exception {
		try {
			logger.info("----> department list ");

			List<Departments> departmentList = departmentRepository.findAll();
			List<DepartmentsBean> departmentsBeans = new ArrayList<DepartmentsBean>();
			DepartmentsBean departmentsBean = null;
			for (Departments departments : departmentList) {
				departmentsBean = new DepartmentsBean();
				departmentsBean.setDeptNo(departments.getDeptNo());
				departmentsBean.setDeptName(departments.getDeptName());
				departmentsBeans.add(departmentsBean);
			}

			return ResponseEntity.ok().body(departmentsBeans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<DepartmentsBean> getDepartmentsById(@PathVariable(value = "id") String departmentId)
			throws Exception {

		try {

			logger.info("----> departmentId - " + departmentId);
			Departments departments = departmentRepository.findById(departmentId)
					.orElseThrow(() -> new Exception("Departments not found for this deptId :: " + departmentId));

			DepartmentsBean departmentsBean = new DepartmentsBean();
			departmentsBean.setDeptNo(departments.getDeptNo());
			departmentsBean.setDeptName(departments.getDeptName());

			return ResponseEntity.ok().body(departmentsBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping(path = "/")
	public ResponseEntity<Departments> createDepartment(@Valid @RequestBody Departments department) throws Exception {

		try {
			departmentRepository.save(department);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(department.getDeptNo()).toUri();

			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@PutMapping(path = "/{deptId}")
	public ResponseEntity<Departments> updateEmployee(@PathVariable(value = "deptId") String departmentId,
			@Valid @RequestBody Departments employeeDetails) throws ResourceNotFoundException {

		try {

			Departments department = departmentRepository.findById(departmentId).orElseThrow(
					() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

			final Departments updatedDepartment = departmentRepository.save(department);

			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(updatedDepartment.getDeptNo()).toUri();

			return ResponseEntity.created(location).build();
		} catch (ResourceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}

	@DeleteMapping(path = "/{deptId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "deptId") String departmentId)
			throws ResourceNotFoundException {

		try {
			Departments department = departmentRepository.findById(departmentId).orElseThrow(
					() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

			departmentRepository.delete(department);
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