package com.hessian.server.conf;

import com.hessian.server.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * @Description 配置类,提供本地实例
 * @Fiel com.hessian.server.conf.ConfigBean
 * @Author jaood
 * @Date 2017/8/10 17:08
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
public class ConfigBean {

    /** 暴露接口地址 */
    private static final String PROVIDE_SERVICE_NAME="/TestService";

    @Autowired
    private TestService testService;

    /**
     * @Description 设置本地实例到Hessian中，暴露接口地址
     * @Author jaood
     * @Date 2017/8/10 17:48
     * @Param []
     * @Return org.springframework.remoting.caucho.HessianServiceExporter
     */
    @Bean(PROVIDE_SERVICE_NAME)
    public HessianServiceExporter accountService() {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(testService);
        exporter.setServiceInterface(TestService.class);
        return exporter;
    }
}
