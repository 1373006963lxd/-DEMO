package com.didi.study.service.serviceImpl;

import com.didi.study.cache.CancelPublishSender;
import com.didi.study.mbg.mapper.QuestionMapper;
import com.didi.study.mbg.model.Question;
import com.didi.study.service.CancelPublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 15:33
 */
@Service
public class CancelPublishServiceImpl implements CancelPublishService {
    private static Logger LOGGER = LoggerFactory.getLogger(CancelPublishServiceImpl.class);

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    CancelPublishSender publishSender;

    @Override
    public Object publishQuestion(Question question) {
        int insertQuestion = questionMapper.insert(question);
        sendDelayMessageCancelPublish(question.getId());
        return  insertQuestion;
    }

    @Override
    public void cancelPublish(Integer id) {
        questionMapper.deleteByPrimaryKey(id);
        LOGGER.info("process cancelOrder questionId:{}",id);
    }

    private void sendDelayMessageCancelPublish(Integer id) {
        //获取订单超时时间，假设为60分钟
        long delayTimes = 30 * 1000;
        //发送延迟消息
        publishSender.sendMessage(id, delayTimes);
    }
}
