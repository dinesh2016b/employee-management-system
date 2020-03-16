package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class EmployeeEMSApplication extends SpringBootServletInitializer {

	// start everything
	public static void main(String[] args) {
		SpringApplication.run(EmployeeEMSApplication.class, args);
	}

// run this only on profile 'demo', avoid run this in test
	/*
	 * @Profile("demo")
	 * 
	 * @Bean CommandLineRunner initDatabase(EmployeeRepository repository) { return
	 * args -> { repository.save(new Employee("FirstName", "LastName",
	 * "2019/07/28")); repository.save(new Employee("FirstName1", "LastName1",
	 * "2019/07/28")); repository.save(new Employee("FirstName2", "LastName2",
	 * "2019/07/28")); }; }
	 * 
	 */
}
