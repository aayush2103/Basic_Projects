package com.udacity.dogMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
/*to enable service discovery as a client on Eureka server*/
@EnableEurekaClient
public class DogMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DogMicroserviceApplication.class, args);
	}

}
