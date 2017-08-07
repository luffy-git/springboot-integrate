package com.jaood.point.conf.bean.active;

import com.jaood.point.conf.bean.constant.QueueConstant;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @Description 注入配置Bean
 * @Fiel com.jaood.point.conf.bean.active.ServerQueue
 * @Author jaood
 * @Date 2017/8/6 1:02
 * @Blog http://blog.csdn.net/jaood
 */
@Configuration
public class ServerQueue {

    private static final Logger LOG = LoggerFactory.getLogger(ServerQueue.class);

    @Bean
    public Queue queue() {
        LOG.info(">>>>> 创建Queue:{} <<<<<", QueueConstant.POINT_QUEUE);
        return new ActiveMQQueue(QueueConstant.POINT_QUEUE);
    }
}
