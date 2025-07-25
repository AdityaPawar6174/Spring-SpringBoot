package com.infosys.Terminal_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TerminalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalServiceApplication.class, args);
	}

}
