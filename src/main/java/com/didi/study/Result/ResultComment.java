package com.didi.study.Result;

import com.didi.study.resultEnum.ResultEnum;
import lombok.Data;

/**
 * @auther li xiao dong
 * @date 2020/4/30 0030 下午 16:15
 * 返回类型不能转化为json，是因为没有给返回对象设置set、get方法
 */
@Data
public class ResultComment<T> {
    private Integer code;
    private String message;
    private  T data;

    ResultComment(Integer code,String message,T data){
        this.code= code;
        this.message=message;
        this.data=data;
    }
    public static<T> ResultComment<T> success(T data){
        return new ResultComment<T>(ResultEnum.SUCCESS.getCode(),ResultEnum.SUCCESS.getMessage(),data);
    }
    public static<T> ResultComment<T> error(){
        return new ResultComment<>(ResultEnum.ERROT.getCode(),ResultEnum.ERROT.getMessage(),null);
    }

    public static ResultComment failed(String message) {
        return new ResultComment(ResultEnum.ERROT.getCode(),message,null);
    }
}
