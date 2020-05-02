package com.didi.study.controller;

import com.didi.study.cache.HotTagCache;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/5/1 0001 下午 13:38
 */
@RestController
@Api(value = "定时获取热点标签",tags = "定时获取热点标签")
@RequestMapping("/get")
public class ScheduleController {
    @Autowired
    private HotTagCache hotTagCache;


    @GetMapping("/getTags")
    @ApiOperation("获取热点标签")
    public List getTags(){
        List<String> tags = hotTagCache.getHots();
        return tags;
    }
}
