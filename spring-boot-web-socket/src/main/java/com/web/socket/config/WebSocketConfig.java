package com.web.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @Description 配置类
 * @Fiel com.web.socket.config.WebSocketConfig
 * @Author jaood
 * @Date 2017/8/10 14:47
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
@EnableWebSocketMessageBroker
//通过EnableWebSocketMessageBroker 开启使用STOMP协议来传输基于代理(message broker)的消息,
// 此时浏览器支持使用@MessageMapping 就像支持@RequestMapping一样。
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     * @Description  endPoint 注册协议节点,并映射指定的URl
     * @Author jaood
     * @Date 2017/8/10 14:48
     * @Param [registry]
     * @Return void
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注册一个名字为"endpointChat" 的endpoint,并指定 SockJS协议。   点对点-用
        registry.addEndpoint("/endpointChat").withSockJS();
    }


    /**
     * @Description  配置消息代理(message broker)
     * @Author jaood
     * @Date 2017/8/10 14:49
     * @Param [registry]
     * @Return void
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //点对点式增加一个/queue 消息代理
        registry.enableSimpleBroker("/queue","/topic");

    }
}