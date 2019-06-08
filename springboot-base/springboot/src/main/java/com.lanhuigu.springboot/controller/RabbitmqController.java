package com.lanhuigu.springboot.controller;

import com.lanhuigu.springboot.message.producter.LanhuiguProductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot集成RabbitMQ
 *
 * @author yihonglei
 * @date 2019-06-07 17:41
 */
@RestController
public class RabbitmqController {

    @Autowired
    private LanhuiguProductor lanhuiguProductor;
    @RequestMapping("/testMqSender/{msg}")
    public String testMqSender(@PathVariable("msg") String msg) {
        lanhuiguProductor.sendMsg(msg);
        return "OK";
    }

    @RequestMapping("/testFanoutMqSender/{msg}")
    public String testFanoutMqSender(@PathVariable("msg") String msg) {
        lanhuiguProductor.sendMsg2Fanout(msg);
        return "OK";
    }

    @RequestMapping("/testTopicSender/{msg}")
    public String testTopicSender(@PathVariable("msg") String msg) {
        lanhuiguProductor.sendMsg2Topic(msg);
        return "OK";
    }
}
