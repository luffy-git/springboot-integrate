package com.hessian.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootHessianClientApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(SpringBootHessianClientApplicationTests.class);

	/** 上下文 */
	@Autowired
	private WebApplicationContext context;
	/** controller测试 */
	private MockMvc mockMvc;

	/**
	 * @Description 初始化执行
	 * @Author jaood
	 * @Date 2017/8/8 0:56
	 * @Param []
	 * @Return void
	 */
	@Before
	public  void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		LOG.info("<<<<<<<<<<<<<   初始化执行    >>>>>>>>>>>>>>>");
	}

	/**
	 * @Description 测试访问,看能否调用到远程service实例
	 * @Author jaood
	 * @Date 2017/8/10 17:53
	 * @Param []
	 * @Return void
	 */
	@Test
	public void testController() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/test")).andDo(MockMvcResultHandlers.print()).andReturn();
		LOG.info("页面返回结果:"+result.getResponse().getContentAsString());
	}

}
