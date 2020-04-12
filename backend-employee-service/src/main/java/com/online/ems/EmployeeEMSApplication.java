package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class EmployeeEMSApplication extends SpringBootServletInitializer {

	/*
	 * static { //for localhost testing only
	 * javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier( new
	 * javax.net.ssl.HostnameVerifier(){
	 * 
	 * public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
	 * if (hostname.equals("localhost")) { return true; } return false; } }); }
	 */
	
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	};

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
