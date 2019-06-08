package com.lanhuigu.springboot.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * rabbitmq配置类（队列声明，绑定交换机）
 *
 * @author yihonglei
 * @date 2019-06-07 18:19
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * ====== 直接交换机 ======
     */
    @Bean
    public DirectExchange lanhuiguDirectExchange() {
        // 参数 durable:表示消息是否可持久化
        // autoDelete:表示若没有队列和此交换机绑定 就直接删除该交换机
        return new DirectExchange("lanhuiguDirectExchange", true, false);
    }

    @Bean
    public Queue lanhuiguDirectQueue() {
        return new Queue("lanhuiguDirectQueue", true, false, false);
    }

    @Bean
    public Binding lanhuiguDq2De() {
        return BindingBuilder.bind(lanhuiguDirectQueue()).to(lanhuiguDirectExchange()).with("lanhuigu.directkey");
    }

    /**
     * ====== 扇形交换机 ======
     */
    @Bean
    public FanoutExchange lanhuiguFanoutExchange() {
        return new FanoutExchange("lanhuiguFanoutExchange", true, false);
    }

    @Bean
    public Queue lanhuigufanoutQueue1() {
        return new Queue("lanhuiguFanoutQueue1", true, false, false);
    }

    @Bean
    public Queue lanhuigufanoutQueue2() {
        return new Queue("lanhuiguFanoutQueue2", true, false, false);
    }

    @Bean
    public Binding lanhuiguBind1() {
        return BindingBuilder.bind(lanhuigufanoutQueue1()).to(lanhuiguFanoutExchange());

    }

    @Bean
    public Binding lanhuiguBind2() {
        return BindingBuilder.bind(lanhuigufanoutQueue2()).to(lanhuiguFanoutExchange());
    }

    /**
     * ====== 主题交换机 ======
     */
    @Bean
    public TopicExchange lanhuiguTopicExchange() {
        return new TopicExchange("lanhuiguTopicExchange", true, false);
    }

    @Bean
    public Queue lanhuiguTopicQueue() {
        return new Queue("lanhuiguTopicQueue", true, false, false);
    }

    @Bean
    public Queue lanhuiguTopicQueue2() {
        return new Queue("lanhuiguTopicQueue2", true, false, false);
    }

    @Bean
    public Binding topicBind1() {
        return BindingBuilder.bind(lanhuiguTopicQueue()).to(lanhuiguTopicExchange()).with("topic.key.#");

    }

    @Bean
    public Binding topicBind2() {
        return BindingBuilder.bind(lanhuiguTopicQueue2()).to(lanhuiguTopicExchange()).with("#.key");

    }

}
