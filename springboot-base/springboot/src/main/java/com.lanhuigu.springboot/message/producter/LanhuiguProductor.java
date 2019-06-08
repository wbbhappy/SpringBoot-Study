package com.lanhuigu.springboot.message.producter;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 生产者
 *
 * @author yihonglei
 * @date 2019-06-07 17:42
 */
@Component
public class LanhuiguProductor {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
        Map<String, Object> msgProps = new HashMap<>();
        MessageHeaders messageHeaders = new MessageHeaders(msgProps);

        Message message = MessageBuilder.createMessage(msg, messageHeaders);
        String msgId = UUID.randomUUID().toString();
        System.out.println("生成的全局唯一性ID" + msgId);
        CorrelationData correlationData = new CorrelationData(msgId);
        //rabbitTemplate.convertAndSend("lanhuiguDirectExchange","lanhuigu.directkey",message,correlationData);
        Map<String, Object> sendContext = new HashMap<>();
        sendContext.put("name", "张三");
        sendContext.put("sex", "男");
        rabbitTemplate.convertAndSend("lanhuiguDirectExchange", "lanhuigu.directkey", sendContext);
    }

    /**
     * 发送到扇形交换机上
     */
    public void sendMsg2Fanout(String msg) {
        Map<String, Object> msgProps = new HashMap<>();
        MessageHeaders messageHeaders = new MessageHeaders(msgProps);
        Message message = MessageBuilder.createMessage(msg, messageHeaders);
        String msgId = UUID.randomUUID().toString();
        System.out.println("生成的全局唯一性ID" + msgId);
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend("lanhuiguFanoutExchange", "aaaabbdd", message, correlationData);

    }


    /**
     * 发送到扇形交换机上
     */
    public void sendMsg2Topic(String msg) {
        Map<String, Object> msgProps = new HashMap<>();
        MessageHeaders messageHeaders = new MessageHeaders(msgProps);
        Message message = MessageBuilder.createMessage(msg, messageHeaders);
        String msgId = UUID.randomUUID().toString();
        System.out.println("生成的全局唯一性ID" + msgId);
        CorrelationData correlationData = new CorrelationData(msgId);

        rabbitTemplate.convertAndSend("lanhuiguTopicExchange", "topic.key.aaa", message, correlationData);
        rabbitTemplate.convertAndSend("lanhuiguTopicExchange", "aa.key", message, correlationData);
    }


}
