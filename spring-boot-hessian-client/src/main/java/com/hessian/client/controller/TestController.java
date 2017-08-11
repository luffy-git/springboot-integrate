package com.hessian.client.controller;

import com.hessian.client.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Fiel com.hessian.client.controller.TestController
 * @Author jaood
 * @Date 2017/8/10 16:53
 * @Blog http://blog.csdn.net/jaood
 */
@RestController
public class TestController {

    /** 自动注入service */
    @Autowired
    TestService testService;

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public String test(){
        return testService.sayHay("jaood.");
    }
}
