package com.ead.notification_hex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NotificationHexApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationHexApplication.class, args);
	}

}
