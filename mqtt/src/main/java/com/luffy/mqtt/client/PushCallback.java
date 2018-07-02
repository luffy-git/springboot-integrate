package com.luffy.mqtt.client;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by Jimmy on 2018/6/28
 */
@Slf4j
public class PushCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        log.info("连接断开，可以做重连");
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("deliveryComplete---------" + token.isComplete());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        log.info("接收消息主题 : " + topic);
        log.info("接收消息ID : " + message.getId());
        log.info("接收消息Qos : " + message.getQos());
        log.info("接收消息内容 : " + new String(message.getPayload()));
    }

    public static void main(String[] args) {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setId(1231312);
        mqttMessage.setPayload("ceshi".getBytes());
        mqttMessage.setQos(0);
        mqttMessage.setRetained(true);
        System.out.println(JSON.toJSONString(mqttMessage));
    }
}
