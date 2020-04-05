package com.online.ems.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.online.ems.bean.SalariesBean;

@FeignClient(name = "backend-salaries-service")
public interface SalariesServiceProxy {

	@GetMapping(path = "/salaries")
	public SalariesBean getSalariesByEmployeeId(String departmentId) throws Exception;

}
