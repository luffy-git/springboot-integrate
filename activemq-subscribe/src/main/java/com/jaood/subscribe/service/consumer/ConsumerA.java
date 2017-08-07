package com.jaood.subscribe.service.consumer;

import com.jaood.subscribe.constant.QueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description  消费者A
 * @Fiel com.jaood.subscribe.service.consumer.ConsumerA
 * @Author jaood
 * @Date 2017/8/6 13:24
 * @Blog http://blog.csdn.net/jaood
 */
@Component
public class ConsumerA {

    private static final Logger LOG = LoggerFactory.getLogger(ConsumerA.class);

    /**
     * @Description 监听,消费发布内容
     * @Author jaood
     * @Date 2017/8/6 1:13
     * @Param [message]
     * @Return void
     */
    @JmsListener(destination = QueueConstant.TOPIC_QUEUE)
    public void receiveTopicQueue(String message) {
        //TODO
        LOG.info("消费者ConsumerA：" + QueueConstant.TOPIC_QUEUE + "收到:{}", message);
    }
}
