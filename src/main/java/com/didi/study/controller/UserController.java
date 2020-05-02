package com.didi.study.controller;

import com.didi.study.mbg.model.User;
import com.didi.study.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther li xiao dong
 * @date 2020/4/30 0030 下午 14:40
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户的基本操作",tags = "用户的基本操作")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("根据id查询用户")
    @GetMapping("/findUser")
    public User findById(@ApiParam(value = "用户id") @RequestParam(name = "id",required = true) Integer id){
        User user = userService.findById(id);
        return user;
    }

}

