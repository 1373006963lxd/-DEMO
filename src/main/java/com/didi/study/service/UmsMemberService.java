package com.didi.study.service;

import com.didi.study.Result.ResultComment;

public interface UmsMemberService {

    /**
     * 生成验证码
     */
    ResultComment generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    ResultComment verifyAuthCode(String telephone, String authCode);

}
