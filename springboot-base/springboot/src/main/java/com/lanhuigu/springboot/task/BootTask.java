package com.lanhuigu.springboot.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 通过@Scheduled创建任务
 *
 * @author yihonglei
 * @date 2019/1/7 16:54
 */
@Component
public class BootTask {

    @Scheduled(fixedDelay = 1000)
    public void test01() {
        System.out.println("test01 start");
        System.out.println("执行业务逻辑...");
        System.out.println("test01 end");
    }

    @Scheduled(fixedDelay = 1000)
    public void test02() {
        System.out.println("test02 start");
        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test02 end");
    }

}
