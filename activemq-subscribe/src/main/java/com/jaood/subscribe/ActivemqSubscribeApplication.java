package com.jaood.subscribe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext-*.xml")
public class ActivemqSubscribeApplication {

	private static final Logger LOG = LoggerFactory.getLogger(ActivemqSubscribeApplication.class);

	public static void main(String[] args) {
		LOG.info("<<<<<<   启动    >>>>>>>");
		SpringApplication.run(ActivemqSubscribeApplication.class, args);
		LOG.info("INFO");
		LOG.error("错误");
		LOG.debug("DEBUG");
		LOG.warn("WARN");
	}
}
