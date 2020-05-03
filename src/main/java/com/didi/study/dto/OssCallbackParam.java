package com.didi.study.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * oss上传成功后的回调参数
 * @auther li xiao dong
 * @date 2020/5/3 0003 下午 14:52
 */
@Data
public class OssCallbackParam {
    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;
    @ApiModelProperty("回调时传入request中的参数")
    private String callbackBody;
    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;
}
