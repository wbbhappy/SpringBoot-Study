package com.lanhuigu.springboot.message.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


/**
 * 消费者
 *
 * @author yihonglei
 * @date 2019-06-07 17:43
 */
@Component
public class LanhuiguConsumer {

    @RabbitListener(queues = "lanhuiguDirectQueue")
    public void consumerMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload().toString());
    }

    @RabbitListener(queues = "lanhuiguFanoutQueue1")
    public void consumerFanoutMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "lanhuiguFanoutQueue2")
    public void consumerFanoutMsg2(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "lanhuiguTopicQueue")
    public void consumerTopicMsg(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

    @RabbitListener(queues = "lanhuiguFanoutQueue2")
    public void consumerTopicMsg2(Message message) {

        System.out.println("消费消息:" + message.getPayload());
    }

}
