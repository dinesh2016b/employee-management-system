package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.online.ems")
public class BackendZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendZuulApiGatewayServerApplication.class, args);
	}
}
