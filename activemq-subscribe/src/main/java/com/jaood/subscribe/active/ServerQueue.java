package com.jaood.subscribe.active;

import com.jaood.subscribe.constant.QueueConstant;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @Description 注入配置Bean
 * @Fiel com.jaood.subscribe.conf.bean.active.ServerQueue
 * @Author jaood
 * @Date 2017/8/6 13:20
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
public class ServerQueue {

    private static final Logger LOG = LoggerFactory.getLogger(ServerQueue.class);

    @Bean
    public Topic topic() {
        LOG.info(">>>>> 创建Topic:{} <<<<<", QueueConstant.TOPIC_QUEUE);
        return new ActiveMQTopic(QueueConstant.TOPIC_QUEUE);
    }
}
