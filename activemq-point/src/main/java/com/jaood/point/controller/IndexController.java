package com.jaood.point.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @Description
 * @Fiel com.jaood.point.controller.IndexController
 * @Author jaood
 * @Date 2017/8/6 0:23
 * @Blog http://blog.csdn.net/jaood
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Map<String,Object> map){
        map.put("hello","jaood");
        return "index";
    }
}
