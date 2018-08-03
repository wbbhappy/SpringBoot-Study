package com.lanhuigu.springboot.service.impl;

import com.lanhuigu.springboot.service.HelloService;
import com.lanhuigu.springboot.util.HashRedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yihonglei
 * @date 2018/8/3 19:21
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private RedisTemplate<String, String> redis;

    @Override
    public String sayHello(String name) {
        HashRedisUtil.hset(redis, "user", "name", "TestSpringBootRedis");
        return "Hello, " + name;
    }

}
