package com.didi.study.service;

import com.didi.study.dto.OssCallbackResult;
import com.didi.study.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther li xiao dong
 * @date 2020/5/3 0003 下午 14:56
 */
public interface OssService {
    /**
     * oss上传策略生成
     */
    OssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
}
