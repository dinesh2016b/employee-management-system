package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//@EnableDiscoveryClient
@Slf4j
public class DepartmentEMSApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentEMSApplication.class, args);
		logger.info("---> DepartmentEMSApplication... started....");
	}

	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */
}
