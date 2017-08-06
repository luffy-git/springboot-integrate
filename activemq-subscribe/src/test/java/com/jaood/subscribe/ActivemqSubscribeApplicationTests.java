package com.jaood.subscribe;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivemqSubscribeApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(ActivemqSubscribeApplicationTests.class);

	@Autowired
	StringEncryptor stringEncryptor;


	/**
	 * @Description ActiveMq密码加密
	 * @Author jaood
	 * @Date 2017/8/6 12:57
	 * @Param []
	 * @Return void
	 */
	@Test
	public void encryptActiveMqPwd() {
		String result = stringEncryptor.encrypt("your activemq  password");
		LOG.info(result);
	}


	@Test
	public void contextLoads() {
	}

}
