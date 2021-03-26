package com.devcenter.apptest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApptestApplication.class, args);
	}

}
