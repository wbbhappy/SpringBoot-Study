package com.lanhuigu.springboot.controller;

import com.lanhuigu.springboot.domain.Cat;
import com.lanhuigu.springboot.service.ICatService;
import com.lanhuigu.springboot.service.impl.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: yihonglei
 * @date: 2019-06-04 10:49
 */
@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private ICatService catService;

    /**
     * 保存数据
     */
    @RequestMapping("/save")
    public String save() {
        Cat cat = new Cat();
        //cat.setId(1); // 通过MySQL主键自增长策略生成
        cat.setCatName("hello kitty");
        cat.setCatAge(26);
        catService.save(cat);

        return "save ok";
    }

    /**
     * 删除数据
     */
    @RequestMapping("/delete")
    public String delete() {
        // 这里只删了id为1的
        catService.delete(1);

        return "delete ok";
    }

    /**
     * 查询数据
     */
    @RequestMapping("/getAll")
    public Iterable<Cat> getAll() {

        return catService.getAll();
    }

    /**
     * jdbcTemplate查询数据使用
     */
    @RequestMapping("/queryByCatName")
    public Cat queryByCatName(String catName) {

        return catService.queryByCatName(catName);
    }
}
