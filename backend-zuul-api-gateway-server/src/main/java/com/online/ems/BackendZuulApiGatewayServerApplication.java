package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
//@EnableDiscoveryClient
@Slf4j
public class BackendZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		logger.info("-----> BackendZuulApiGatewayServerApplication started...");
		SpringApplication.run(BackendZuulApiGatewayServerApplication.class, args);
	}
	/*
	 * @Bean public Sampler defaultSampler() { return Sampler.ALWAYS_SAMPLE; }
	 */
}
