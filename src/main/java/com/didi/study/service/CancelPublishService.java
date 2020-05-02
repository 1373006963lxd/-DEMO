package com.didi.study.service;

import com.didi.study.mbg.model.Question;
import org.springframework.transaction.annotation.Transactional;

public interface CancelPublishService {

    @Transactional
    Object publishQuestion(Question question);

    @Transactional
    void cancelPublish(Integer id);
}
