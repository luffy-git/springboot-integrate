package com.luffy.mqtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jimmy on 2018/6/29
 */
@Controller
public class MqController {

    @RequestMapping(value = "/index2",method = RequestMethod.GET)
    public String index2(){
        return "index2";
    }
}
