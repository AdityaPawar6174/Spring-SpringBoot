package com.infosys.ClientService_CloudRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientServiceCloudRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceCloudRestApplication.class, args);
	}

}
