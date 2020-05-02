package com.didi.study.mbg;

/**
 * @auther li xiao dong
 * @date 2020/4/30 0030 下午 12:10
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.didi.study.mbg.mapper","com.didi.study.dao"})
public class MyBatisConfig {

}
