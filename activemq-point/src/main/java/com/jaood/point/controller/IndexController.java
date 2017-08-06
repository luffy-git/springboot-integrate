package com.jaood.point.controller;

import com.jaood.point.service.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description 测试Controller
 * @Fiel com.jaood.point.controller.IndexController
 * @Author jaood
 * @Date 2017/8/6 0:23
 * @Blog http://blog.csdn.net/jaood
 */
@Controller
public class IndexController {

    @Autowired
    private Producer producer;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
        map.put("hello", "jaood");
        return "index";
    }

    /**
     * @Description 手动发送
     * @Author jaood
     * @Date 2017/8/6 13:07
     * @Param [msg]
     * @Return java.lang.String
     */
    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    @ResponseBody
    public String send(@PathVariable String msg) {
        try {
            producer.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "发送成功";
    }
}
