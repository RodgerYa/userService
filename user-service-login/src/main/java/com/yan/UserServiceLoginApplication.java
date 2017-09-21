package com.yan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yan.user.utils")
public class UserServiceLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceLoginApplication.class, args);
	}
}
