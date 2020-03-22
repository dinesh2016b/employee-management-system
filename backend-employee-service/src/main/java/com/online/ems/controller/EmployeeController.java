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
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
	public ResponseEntity<List<Resource<Employees>>> getAllEmployees(Principal principal) throws Exception {
		logger.info("----> employeeId - List ");

		// return ResponseEntity.ok().body(employeeRepository.findAll());

		Employees employee = null;
		Resource<Employees> employesResource = null;
		List<Resource<Employees>> list = new ArrayList<Resource<Employees>>();

		for (int i = 10001; i < 10021; i++) {
			employee = employeeRepository.findById((long) i)
					.orElseThrow(() -> new Exception("Employees not found for this empNo :: "));

			employesResource = new Resource<Employees>(employee);
			employesResource.add(
					linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getEmpNo())).withRel("_self"));

			list.add(employesResource);
		}

		logger.info(
				"------------------>>> You are logged in as :" + principal.getName() + " : " + principal.toString());
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Resource<Employees>> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws Exception {
		try {

			logger.info("----> employeeId - " + employeeId);
			Employees employee = employeeRepository.findById(employeeId)
					.orElseThrow(() -> new Exception("Employees not found for this empNo :: " + employeeId));

			Resource<Employees> employesResource = new Resource<Employees>(employee);
			employesResource.add(linkTo(methodOn(EmployeeController.class).getAllEmployees(null)).withRel("_self"));

			return ResponseEntity.ok().body(employesResource);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostMapping("/employees")
	public ResponseEntity<Employees> createEmployee(@Valid @RequestBody Employees employee) {
		logger.info("------------------>>> createEmployee() :"+employee.toString());
		logger.info("------------------>>> "+employeeRepository.save(employee));
		return ResponseEntity.ok(employee);
	}

	@PutMapping("/employees/{empNo}")
	public ResponseEntity<Employees> updateEmployee(@PathVariable(value = "empNo") Long employeeId,
			@Valid @RequestBody Employees employeeDetails) throws ResourceNotFoundException {

		logger.info("------------------>>> updateEmployee()");
		Employees employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employees not found for this empNo :: " + employeeId));

		employee.setBirthDate(employeeDetails.getBirthDate());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employees updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{empNo}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "empNo") Long employeeId)
			throws ResourceNotFoundException {

		logger.info("------------------>>> deleteEmployee()");
		Employees employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employees not found for this empNo :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}