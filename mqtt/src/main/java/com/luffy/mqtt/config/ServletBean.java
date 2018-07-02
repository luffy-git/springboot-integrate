package com.luffy.mqtt.config;

import com.luffy.mqtt.util.PropertiesUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.web.AjaxServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimmy on 2018/6/28
 */
@Configuration
public class ServletBean {

    @Bean
    public ServletRegistrationBean amqServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(new AjaxServlet());
        registrationBean.setLoadOnStartup(1);
        List<String> urlMappings=new ArrayList();
        urlMappings.add("/amq/*");
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }

    @Bean
    public ServletContextInitializer initializer() {
        return servletContext -> servletContext.setAttribute("org.apache.activemq.connectionFactory",new ActiveMQConnectionFactory(PropertiesUtil.MQTT_USER_NAME, PropertiesUtil.MQTT_PASSWORD, PropertiesUtil.MQTT_HOST));
    }
}
