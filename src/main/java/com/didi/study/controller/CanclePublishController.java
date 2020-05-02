package com.didi.study.controller;

import com.didi.study.mbg.model.Question;
import com.didi.study.service.CancelPublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 15:17
 */
@RestController
@Api(tags = "RabbitMq延迟发布",value = "RabbitMq延迟发布")
@RequestMapping("/publish")
public class CanclePublishController {


    @Autowired
    CancelPublishService cancelPublishService;



    @ApiOperation("发布问题")
    @PostMapping("/publishQuestion")
    public Object publishQuestion(@Valid @RequestBody Question question){
        Object object = cancelPublishService.publishQuestion(question);
        return object;
    }
}
