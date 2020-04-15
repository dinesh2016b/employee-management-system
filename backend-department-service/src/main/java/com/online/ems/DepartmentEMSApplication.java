package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//@EnableDiscoveryClient
public class DepartmentEMSApplication extends SpringBootServletInitializer {

	// start everything
	public static void main(String[] args) {
		SpringApplication.run(DepartmentEMSApplication.class, args);
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
