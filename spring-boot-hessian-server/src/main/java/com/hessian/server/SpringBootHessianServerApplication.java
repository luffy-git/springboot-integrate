package com.hessian.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHessianServerApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootHessianServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHessianServerApplication.class, args);
		LOG.info("<<<<<<<    启动成功    >>>>>>>>");
	}
}
