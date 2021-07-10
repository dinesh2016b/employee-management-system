package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "com.online.ems")
public class EurekaServerMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerMainApplication.class, args);
	}
}
