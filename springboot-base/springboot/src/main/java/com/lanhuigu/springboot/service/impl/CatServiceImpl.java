package com.lanhuigu.springboot.service.impl;

import com.lanhuigu.springboot.dao.CatRepository;
import com.lanhuigu.springboot.domain.Cat;
import com.lanhuigu.springboot.service.CatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * cat service:
 * save，update，delete方法需要绑定事务。
 * 使用@Transactional进行事务绑定。
 *
 * @auther: yihonglei
 * @date: 2019-06-04 10:46
 */
@Service
public class CatServiceImpl implements CatService {
    @Resource
    private CatRepository catRepository;

    /**
     * 保存数据
     */
    @Transactional
    @Override
    public void save(Cat cat) {

        catRepository.save(cat);
    }

    /**
     * 删除数据
     */
    @Transactional
    @Override
    public void delete(int id) {

        catRepository.delete(id);
    }

    /**
     * 查询数据
     */
    @Override
    public Iterable<Cat> getAll() {

        return catRepository.findAll();
    }
}
