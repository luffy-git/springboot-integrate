package com.hessian.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHessianClientApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootHessianClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHessianClientApplication.class, args);
		LOG.info("<<<<<<<    启动成功    >>>>>>>>");
	}
}
