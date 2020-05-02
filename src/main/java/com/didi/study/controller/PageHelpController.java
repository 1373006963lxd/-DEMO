package com.didi.study.controller;

import com.didi.study.mbg.model.Question;
import com.didi.study.service.PageInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/5/1 0001 下午 16:38
 */
@Api(tags = "测试pageHelper",value = "测试pageHelper")
@RestController
@RequestMapping("/pageInfo")
public class PageHelpController {
    @Autowired
    PageInfoService pageInfoService;

    @ApiOperation("pageHelper获取分页查询的基本信息")
    @GetMapping("/getInfo")
    public PageInfo getPageInfo(@ApiParam("页数") @RequestParam Integer page, @ApiParam("大小") @RequestParam Integer pageSize){
        PageHelper.startPage(page,pageSize);
        List<Question> list=pageInfoService.searchAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
