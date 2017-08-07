package com.jaood.subscribe.service.producer;

import com.jaood.subscribe.constant.QueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @Description 生产者
 * @Fiel com.jaood.subscribe.service.producer.Producer
 * @Author jaood
 * @Date 2017/8/6 13:28
 * @Blog http://blog.csdn.net/jaood
 */
@Component
@EnableScheduling
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    /**
     * jsm操作模版
     */
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 队列
     */
    @Autowired
    private Topic topic;

    /**
     * @Description 每三秒钟生产一条记录
     * @Author jaood
     * @Date 2017/8/6 1:14
     * @Param []
     * @Return void
     */
    @Scheduled(fixedDelay = 3000)
    public void send() throws Exception {
        //TODO
        String message = "发往" + QueueConstant.TOPIC_QUEUE + "的消息;";
        this.jmsMessagingTemplate.convertAndSend(this.topic, message);
        LOG.info(Thread.currentThread().getName() + "--生产：{}", message);
    }

    /**
     * @Description 手动发送消息, 直接调用即可
     * @Author jaood
     * @Date 2017/8/6 1:14
     * @Param [message]
     * @Return void
     */
    public void send(String message) throws Exception {
        //TODO
        this.jmsMessagingTemplate.convertAndSend(this.topic, message);
        LOG.info(Thread.currentThread().getName() + "--生产：{}", message);
    }
}
