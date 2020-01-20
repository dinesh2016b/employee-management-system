package com.online.ems.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.online.ems.dao.DepartmentRepository;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Departments;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
	
	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);	

	@Autowired
	private DepartmentRepository departmentRepository;

	@GetMapping("/departments")
	public ResponseEntity<List<Departments>> getAllEmployees() throws Exception {
		logger.info("----> department list ");

		List<Departments> departmentList = new ArrayList<Departments>();
				
		departmentList = departmentRepository.findAll();
		
		return ResponseEntity.ok().body(departmentList);	
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<List<Departments>> getEmployeeById(@PathVariable(value = "id") Long departmentId)
			throws Exception {
		try {
			logger.info("----> departmentId - " + departmentId);
			Departments department = departmentRepository.findById(departmentId).orElseThrow(
					() -> new Exception("Departments not found for this deptId :: " + departmentId));
			List<Departments> list = new ArrayList<Departments>();
			list.add(department);
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping("/departments")
	public Departments createEmployee(@Valid @RequestBody Departments department) {
		return departmentRepository.save(department);
	}

	@PutMapping("/departments/{deptId}")
	public ResponseEntity<Departments> updateEmployee(@PathVariable(value = "deptId") Long departmentId,
			@Valid @RequestBody Departments employeeDetails) throws ResourceNotFoundException {
		Departments department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

		final Departments updatedEmployee = departmentRepository.save(department);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/departments/{deptId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "deptId") Long departmentId)
			throws ResourceNotFoundException {
		Departments department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

		departmentRepository.delete(department);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}