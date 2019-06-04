package com.lanhuigu.springboot.controller;

import com.lanhuigu.springboot.vo.UserVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 *
 * @auther: yihonglei
 * @date: 2019-06-02 09:41
 */
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public UserVO getUser() {
        UserVO user = new UserVO();
        user.setId(1);
        user.setName("return json");
        return user;
    }
}
