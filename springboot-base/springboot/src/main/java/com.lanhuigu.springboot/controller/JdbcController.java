package com.lanhuigu.springboot.controller;

import com.lanhuigu.springboot.domain.Cat;
import com.lanhuigu.springboot.service.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot整合jdbc
 *
 * @auther: yihonglei
 * @date: 2019-06-04 10:49
 */
@RestController
@RequestMapping("/cat")
public class JdbcController {
    @Autowired
    private ICatService catService;

    /**
     * jdbcTemplate查询数据使用
     */
    @RequestMapping("/queryByCatName")
    public Cat queryByCatName(String catName) {

        return catService.queryByCatName(catName);
    }
}
