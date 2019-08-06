package com.online.ems;

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

import com.online.ems.exception.ResourceNotFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@GetMapping("/employees/{empNo}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "empNo") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this empNo :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

	@PutMapping("/employees/{empNo}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "empNo") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this empNo :: " + employeeId));

		employee.setBirthDate(employeeDetails.getBirthDate());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{empNo}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "empNo") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this empNo :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}