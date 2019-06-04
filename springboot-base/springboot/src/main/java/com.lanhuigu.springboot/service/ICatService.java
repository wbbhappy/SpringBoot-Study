package com.lanhuigu.springboot.service;

import com.lanhuigu.springboot.domain.Cat;

/**
 * 接口
 *
 * @auther: yihonglei
 * @date: 2019-06-04 11:03
 */
public interface ICatService {
    /**
     * 保存数据
     */
    void save(Cat cat);

    /**
     * 删除数据
     */
    void delete(int id);

    /**
     * 查询数据
     */
    Iterable<Cat> getAll();

    /**
     * 根据name查询
     */
    Cat queryByCatName(String catName);
}
