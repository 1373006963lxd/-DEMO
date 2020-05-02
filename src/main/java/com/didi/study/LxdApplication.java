package com.didi.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//添加一个@EnableScheduling注解即可开启SpringTask的定时任务能力。
@EnableScheduling
@MapperScan("life.lxd.community.mapper")
public class LxdApplication {

    public static void main(String[] args) {
        SpringApplication.run(LxdApplication.class, args);
    }

}
