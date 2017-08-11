package com.hessian.server.service.impl;

import com.hessian.server.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Description 接口实现类
 * @Fiel com.hessian.server.service.impl.TestServiceImpl
 * @Author jaood
 * @Date 2017/8/10 17:07
 * @Blog http://blog.csdn.net/jaood
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHay(String name) {
        return "Hello " + name+"";
    }
}
