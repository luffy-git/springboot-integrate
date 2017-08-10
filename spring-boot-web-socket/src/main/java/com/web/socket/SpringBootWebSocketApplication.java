package com.web.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages ="com.web.socket")
@SpringBootApplication
@EnableScheduling
public class SpringBootWebSocketApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebSocketApplication.class, args);
	}
}
