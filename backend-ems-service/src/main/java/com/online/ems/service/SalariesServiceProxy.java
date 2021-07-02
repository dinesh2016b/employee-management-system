package com.online.ems.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.online.ems.bean.SalariesBean;

//@FeignClient(name = "backend-salaries-service", url = "localhost:8093")
//@FeignClient(name = "backend-salaries-service")

@FeignClient(name = "backend-zuul-api-gateway-server")
@RibbonClient(name = "backend-salaries-service")
public interface SalariesServiceProxy {

	// @GetMapping(path = "/salaries/{id}")
	@GetMapping(path = "/backend-salaries-service/salaries/{id}")
    SalariesBean getSalariesByEmployeeId(@PathVariable(value = "id") long id) throws Exception;

}
