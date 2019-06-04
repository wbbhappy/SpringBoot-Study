package com.lanhuigu.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController这个注解等价于spring mvc用法中的@Controller+@ResponseBody
 * @auther: yihonglei
 * @date: 2019-06-04 17:50
 */
@RestController
@PropertySource(value = {"classpath:application.properties"}, encoding = "utf-8")
public class ValueController {
    /**
     * 使用@value注解，从配置文件读取值
     */
    @Value("${test.value}")
    private String testValueAnno;

    @RequestMapping(value = "myValue")
    @ResponseBody
    private String testValue() {
        System.out.println("测试:" + testValueAnno);

        return testValueAnno;
    }
}
