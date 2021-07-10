package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
//@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.online.ems")
public class BackendZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendZuulApiGatewayServerApplication.class, args);
	}
	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */
}
