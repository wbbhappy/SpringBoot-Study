package com.lanhuigu.springboot.service.impl;

import com.lanhuigu.springboot.service.IHelloService;
import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 * @date 2018/8/3 19:21
 */
@Service
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

}
