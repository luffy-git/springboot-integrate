package com.luffy.mqtt.controller;

import com.luffy.mqtt.client.MqttPushClient;
import com.luffy.mqtt.constant.Constant;
import com.luffy.mqtt.model.message.PushPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description MQ入口Controller
 * @fiel com.luffy.mqtt.controller.TestController
 * @author Jimmy
 * @date 2018-06-28 16:23:48
 */
@Slf4j
@Controller
@RequestMapping(value = "/mqtt")
public class TestController {

    private static final String MP_INDEX = "index";

    /**
     * @description 访问页面
     * @author Jimmy
     * @date 2018-06-28 16:17:01
     * @param
     * @return java.lang.String
     */
    @RequestMapping(value = TestController.MP_INDEX,method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2(){
        return "index2";
    }


    @RequestMapping(value = "send",method = RequestMethod.GET)
    @ResponseBody
    public String send(String content){
        String kdTopic = Constant.Topic.DEFAULT_TOPIC;
        PushPayload pushMessage = PushPayload.getPushPayloadBuider().setMobile("15345715326")
                .setContent(content)
                .bulid();
        MqttPushClient.getInstance().publish(kdTopic, pushMessage);
        return "ok";
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String test(String content,String a) {
        String kdTopic = "luffy";
        PushPayload pushMessage = PushPayload.getPushPayloadBuider().setMobile("15345715326")
                .setContent(content)
                .bulid();
        MqttPushClient.getInstance().publish(kdTopic, pushMessage);
        if (null != a && a.length() > 0) {
            log.info("订阅主题#:" + kdTopic);
            MqttPushClient.getInstance().subscribe(kdTopic);
        }
        return "ok";
    }
}
