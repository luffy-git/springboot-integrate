package com.hessian.client.conf;

import com.hessian.client.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

/**
 * @Description 配置类,获取远程实例
 * @Fiel com.hessian.client.conf.ConfigBean
 * @Author jaood
 * @Date 2017/8/10 16:51
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
public class ConfigBean {


    /** 远程服务地址 */
    private static final String REMOTE_SERVER_URL="http://localhost:8082";
    /** 远程service的Name */
    private static final String SERVER_NAME_TEST_SERVICE = "/TestService";

    /**
     * @Description 获取远程实例,并注入本地服务
     * @Author jaood
     * @Date 2017/8/10 17:47
     * @Param []
     * @Return org.springframework.remoting.caucho.HessianProxyFactoryBean
     */
    @Bean
    public HessianProxyFactoryBean testClientssss() {
        HessianProxyFactoryBean factory = new HessianProxyFactoryBean();
        factory.setServiceUrl(REMOTE_SERVER_URL + SERVER_NAME_TEST_SERVICE);
        factory.setServiceInterface(TestService.class);
        return factory;
    }
}
