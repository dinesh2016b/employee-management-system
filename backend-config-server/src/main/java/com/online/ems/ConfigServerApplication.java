/**
 * 
 */
package com.online.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author dinesh
 *
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
