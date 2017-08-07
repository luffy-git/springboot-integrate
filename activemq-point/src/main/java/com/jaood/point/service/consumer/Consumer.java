package com.jaood.point.service.consumer;

import com.jaood.point.conf.bean.constant.QueueConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消费者
 * @Fiel com.jaood.point.service.consumer.Consumer
 * @Author jaood
 * @Date 2017/8/6 1:11
 * @Blog http://blog.csdn.net/jaood
 */
@Component
public class Consumer {

    private static final Logger LOG = LoggerFactory.getLogger(Consumer.class);

    /**
     * @Description 监听,消费发布内容
     * @Author jaood
     * @Date 2017/8/6 1:13
     * @Param [message]
     * @Return void
     */
    @JmsListener(destination = QueueConstant.POINT_QUEUE)
    public void receivePointQueue(String message) {
        //TODO
        LOG.info(QueueConstant.POINT_QUEUE + "--消费：" + QueueConstant.POINT_QUEUE + "收到:{}", message);
    }


}
