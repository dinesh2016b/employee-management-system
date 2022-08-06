package com.online.ems.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.online.ems.bean.SalariesBean;
import com.online.ems.dao.SalariesRepositoryDAO;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Salaries;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:8080")
public class SalariesController {

	@Autowired
	private SalariesRepositoryDAO salariesRepositoryDAO;

	@GetMapping("/salaries")
	public ResponseEntity<List<Salaries>> getAllSalaries() throws Exception {
		logger.info("----> department list ");

		List<Salaries> salariesList = new ArrayList<Salaries>();
		salariesList = salariesRepositoryDAO.findAll();

		return ResponseEntity.ok().body(salariesList);
	}
	
	@GetMapping("/salaries/{id}")
	public SalariesBean getSalariesByEmployeeId(@PathVariable(value = "id") long id) throws Exception {
		try {

			logger.info("----> employeeId - " + id);
			/*
			Salaries salaries = salariesRepositoryDAO.findById(String.valueOf(id))
					.orElseThrow(() -> new Exception("Salaries not found for this employeeId :: " + String.valueOf(id)));
			*/
			SalariesBean salariesBean = new SalariesBean();
			salariesBean.setSalary(100);
			salariesBean.setToDate(new Date());
			
			return salariesBean;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping("/salaries")
	public Salaries createEmployee(@Valid @RequestBody Salaries salaries) {
		return salariesRepositoryDAO.save(salaries);
	}

	@PutMapping("/salaries/{deptId}")
	public ResponseEntity<Salaries> updateEmployee(@PathVariable(value = "deptId") String departmentId,
			@Valid @RequestBody Salaries employeeDetails) throws ResourceNotFoundException {
		Salaries salaries = salariesRepositoryDAO.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Salaries not found for this deptId :: " + departmentId));

		final Salaries updatedEmployee = salariesRepositoryDAO.save(salaries);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/salaries/{deptId}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "deptId") String departmentId)
			throws ResourceNotFoundException {
		
		Salaries salaries = salariesRepositoryDAO.findById(departmentId).orElseThrow(
				() -> new ResourceNotFoundException("Salaries not found for this deptId :: " + departmentId));

		salariesRepositoryDAO.delete(salaries);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}