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

	@GetMapping("/department")
	public ResponseEntity<List<Departments>> getAllEmployees() throws Exception {
		logger.info("----> departmentId - List ");
		
		//return ResponseEntity.ok().body(employeeRepository.findAll());

		Departments employee = null;
		List<Departments> list = new ArrayList<Departments>();
		
		for (int i= 10001; i < 10021; i++){
			employee = departmentRepository.findById((long) i).orElseThrow(
					() -> new Exception("Departments not found for this deptId :: "));
			list.add(employee);
		}

		return ResponseEntity.ok().body(list);	
	}

	@GetMapping("/departments/{id}")
	public ResponseEntity<List<Departments>> getEmployeeById(@PathVariable(value = "id") Long departmentId)
			throws Exception {
		try {
			logger.info("----> departmentId - " + departmentId);
			Departments employee = departmentRepository.findById(departmentId).orElseThrow(
					() -> new Exception("Departments not found for this deptId :: " + departmentId));
			List<Departments> list = new ArrayList<Departments>();
			list.add(employee);
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping("/departments")
	public Departments createEmployee(@Valid @RequestBody Departments employee) {
		return departmentRepository.save(employee);
	}

	@PutMapping("/departments/{deptId}")
	public ResponseEntity<Departments> updateEmployee(@PathVariable(value = "deptId") Long departmentId,
			@Valid @RequestBody Departments employeeDetails) throws ResourceNotFoundException {
		Departments employee = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

		final Departments updatedEmployee = departmentRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/departments/{deptId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "deptId") Long departmentId)
			throws ResourceNotFoundException {
		Departments employee = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Departments not found for this deptId :: " + departmentId));

		departmentRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}