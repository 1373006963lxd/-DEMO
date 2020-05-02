package com.didi.study.cache;

import com.didi.study.service.CancelPublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 15:48
 */
@Component
@RabbitListener(queues = "mall.order.cancel")
public class CancelPublishReceiver {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelPublishReceiver.class);

    @Autowired
    CancelPublishService cancelPublishService;

    @RabbitHandler
    public void handle(Integer id){
        LOGGER.info("receive delay message questionId:{}",id);
        cancelPublishService.cancelPublish(id);
    }
}
