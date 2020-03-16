package com.online.ems.controller;

import java.security.Principal;
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

import com.online.ems.dao.EmployeeRepositoryDAO;
import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Employees;

@RestController
@CrossOrigin(origins = "https://localhost:8080")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);	

	@Autowired
	private EmployeeRepositoryDAO employeeRepository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employees>> getAllEmployees(Principal principal) throws Exception {
		System.out.println("----> employeeId - List ");
		
		//return ResponseEntity.ok().body(employeeRepository.findAll());

		Employees employee = null;
		List<Employees> list = new ArrayList<Employees>();
		
		for (int i= 10001; i < 10021; i++){
			employee = employeeRepository.findById((long) i).orElseThrow(
					() -> new Exception("Employees not found for this empNo :: "));
			list.add(employee);
		}

		
		System.out.println("------------------>>> You are logged in as " + principal.getName());
		System.out.println("------------------>>> You are logged in as " + principal.toString());
		return ResponseEntity.ok().body(list);	
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<List<Employees>> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws Exception {
		try {
			System.out.println("----> employeeId - " + employeeId);
			Employees employee = employeeRepository.findById(employeeId).orElseThrow(
					() -> new Exception("Employees not found for this empNo :: " + employeeId));
			List<Employees> list = new ArrayList<Employees>();
			list.add(employee);
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping("/employees")
	public Employees createEmployee(@Valid @RequestBody Employees employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{empNo}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "empNo") Long employeeId,
			@Valid @RequestBody Employees employeeDetails) throws ResourceNotFoundException {
		Employees employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employees not found for this empNo :: " + employeeId));

		employee.setBirthDate(employeeDetails.getBirthDate());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employees updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{empNo}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "empNo") Long employeeId)
			throws ResourceNotFoundException {
		Employees employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employees not found for this empNo :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}