package com.infosys.MyServiceRegistry_CloudRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MyServiceRegistryCloudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyServiceRegistryCloudRestApplication.class, args);
	}

}
