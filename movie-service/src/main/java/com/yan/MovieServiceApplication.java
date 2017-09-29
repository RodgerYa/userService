package com.yan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
}
