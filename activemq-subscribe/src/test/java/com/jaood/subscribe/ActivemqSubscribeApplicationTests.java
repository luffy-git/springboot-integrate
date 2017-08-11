package com.jaood.subscribe;

import org.jasypt.encryption.StringEncryptor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.Executor;

@RunWith(SpringRunner.class)
@EnableAsync
@SpringBootTest
public class ActivemqSubscribeApplicationTests {

    private static final Logger LOG = LoggerFactory.getLogger(ActivemqSubscribeApplicationTests.class);

    private RestTemplate template = new RestTemplate();

    /** 加密处理 */
    @Autowired
    StringEncryptor stringEncryptor;
    /** 上下文 */
    @Autowired
    private WebApplicationContext context;
    /** 线程池 */
    @Autowired
    @Qualifier("mySimpleAsync")
    private Executor executor;
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
        System.out.println("jaood——--初始化");
    }


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

    /**
     * @Description 线程池测试
     * @Author jaood
     * @Date 2017/8/8 0:56
     * @Param []
     * @Return void
     */
    @Test
    public void testAsync(){
        executor.execute(()-> {
            System.out.println(Thread.currentThread().getName()+"----------------------");
        });
        System.out.println(Thread.currentThread().getName()+"----------------------");
    }

    /**
     * @Description 访问当前项目controller测试
     * @Author jaood
     * @Date 2017/8/8 0:58
     * @Param []
     * @Return void
     */
    @Test
    public void testController(){
        String forObject =""; //template.getForObject("http://localhost:8082/hello", String.class);
        LOG.info(forObject);
    }


    /**
     * @Description 断言
     * @Author jaood
     * @Date 2017/8/7 23:24
     * @Param
     * @Return
     */
    @Test
    public void testAdd() {
        Assert.assertNotNull("lizhimin");
    }

    /**
     * @Description 方法结束后执行
     * @Author jaood
     * @Date 2017/8/8 0:57
     * @Param []
     * @Return void
     */
    @After
    public  void destroy() {
        System.out.println("退出，资源释放");
    }
}
