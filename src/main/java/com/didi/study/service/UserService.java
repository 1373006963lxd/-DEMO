package com.didi.study.service;

import com.didi.study.mbg.mapper.UserMapper;
import com.didi.study.mbg.model.User;
import com.didi.study.mbg.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/4/30 0030 下午 14:46
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public User findById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
