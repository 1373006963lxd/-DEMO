package com.didi.study.controller;

import com.didi.study.Result.ResultComment;
import com.didi.study.dto.OssCallbackResult;
import com.didi.study.dto.OssPolicyResult;
import com.didi.study.service.serviceImpl.OssServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss相关操作接口
 * @auther li xiao dong
 * @date 2020/5/3 0003 下午 15:15
 */
@Controller
@Api(tags = "OssController", value = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private OssServiceImpl ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public ResultComment<OssPolicyResult> policy() {
        OssPolicyResult result = ossService.policy();
        return ResultComment.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public ResultComment<OssCallbackResult> callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return ResultComment.success(ossCallbackResult);
    }

}
