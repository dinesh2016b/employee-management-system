package com.online.ems;

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

import com.online.ems.exception.ResourceNotFoundException;
import com.online.ems.model.Employees;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);	

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees/")
	public ResponseEntity<List<Employees>> getAllEmployees() {
		System.out.println("----> employeeId - List ");
		return ResponseEntity.ok().body(employeeRepository.findAll());
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