/**
 * 
 */
package com.online.ems.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.ems.bean.EMSBean;
import com.online.ems.service.ConfigurationService;

/**
 * @author dinesh
 *
 */

@RestController
@CrossOrigin(value = "http://localhost:8080")
@RequestMapping("/ems-details")
public class EMSController {

	private Logger logger = LoggerFactory.getLogger(EMSController.class);

	@Autowired
	private ConfigurationService config;

	@GetMapping(path = "/config/{env}")
	public EMSBean getEMSDetails(@PathVariable(value = "env") String env) throws Exception {

		try {

			EMSBean emsBean = new EMSBean();
			emsBean.setTitle(config.getTitle());
			emsBean.setEnvironment(config.getEnvironment());

			logger.debug("------------> Title : " + emsBean.getTitle());
			logger.debug("------------> Environment : " + emsBean.getEnvironment());

			return emsBean;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}
}