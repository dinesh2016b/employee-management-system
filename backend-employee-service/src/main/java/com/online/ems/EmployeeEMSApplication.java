package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.online.ems")
public class EmployeeEMSApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeEMSApplication.class, args);
	}
	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */	
}
