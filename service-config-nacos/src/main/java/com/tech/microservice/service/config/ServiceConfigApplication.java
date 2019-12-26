package com.tech.microservice.service.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ServiceConfigApplication {


	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ServiceConfigApplication.class, args);

		while(true) {
			//When configurations are refreshed dynamically, they will be updated in the Enviroment, therefore here we retrieve configurations from Environment every other second.
			String val1 = applicationContext.getEnvironment().getProperty("app.config.val1");
			String val2 = applicationContext.getEnvironment().getProperty("app.config.val2");
			System.err.println("app.config.val1 :" + val1 + "; app.config.val2: " + val2);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
