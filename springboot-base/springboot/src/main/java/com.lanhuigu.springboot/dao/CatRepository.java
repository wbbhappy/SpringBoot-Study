package com.lanhuigu.springboot.dao;

import com.lanhuigu.springboot.domain.Cat;
import org.springframework.data.repository.CrudRepository;

/**
 * curd操作
 *
 * @auther: yihonglei
 * @date: 2019-06-04 10:45
 */
public interface CatRepository extends CrudRepository<Cat, Integer> {
}
