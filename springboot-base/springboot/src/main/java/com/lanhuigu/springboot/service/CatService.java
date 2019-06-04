package com.lanhuigu.springboot.service;

import com.lanhuigu.springboot.domain.Cat;

/**
 * 接口
 *
 * @auther: yihonglei
 * @date: 2019-06-04 11:03
 */
public interface CatService {
    /**
     * 保存数据
     */
    void save(Cat cat);

    /**
     * 删除数据
     */
    public void delete(int id);

    /**
     * 查询数据
     */
    public Iterable<Cat> getAll();
}
