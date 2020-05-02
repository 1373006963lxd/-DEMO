package com.didi.study.controller;

import com.didi.study.Result.ResultComment;
import com.didi.study.dto.EsQuestion;
import com.didi.study.page.CommonPage;
import com.didi.study.service.EsQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 23:52
 */
@Controller
@Api(tags = "EsQuestionController", value = "搜索问题管理")
@RequestMapping("/esQuestion")
public class EsQuestionController {
    @Autowired
    private EsQuestionService esQuestionService;

    @ApiOperation(value = "导入所有数据库中问题到ES")
    @RequestMapping(value = "/importAll", method = RequestMethod.POST)
    @ResponseBody
    public ResultComment<Integer> importAllList() {
        int count = esQuestionService.importAll();
        return ResultComment.success(count);
    }

    @ApiOperation(value = "根据id删除问题")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResultComment<Object> delete(@PathVariable Integer id) {
        esQuestionService.delete(id);
        return ResultComment.success(null);
    }

    @ApiOperation(value = "根据id批量删除问题")
    @RequestMapping(value = "/delete/batch", method = RequestMethod.POST)
    @ResponseBody
    public ResultComment<Object> delete(@RequestParam("ids") List<Integer> ids) {
        esQuestionService.delete(ids);
        return ResultComment.success(null);
    }

    @ApiOperation(value = "根据id创建问题")
    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultComment<EsQuestion> create(@PathVariable Integer id) {
        EsQuestion esProduct = esQuestionService.create(id);
        if (esProduct != null) {
            return ResultComment.success(esProduct);
        } else {
            return ResultComment.failed("创建失败");
        }
    }

    @ApiOperation(value = "简单搜索")
    @RequestMapping(value = "/search/simple", method = RequestMethod.GET)
    @ResponseBody
    public ResultComment<CommonPage<EsQuestion>> search(@RequestParam(required = false) String keyword,
                                                       @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                       @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsQuestion> esQuestionPage = esQuestionService.search(keyword, pageNum, pageSize);
        return ResultComment.success(CommonPage.restPage(esQuestionPage));
    }

}
