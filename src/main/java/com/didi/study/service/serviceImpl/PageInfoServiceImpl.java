package com.didi.study.service.serviceImpl;

import com.didi.study.mbg.mapper.QuestionMapper;
import com.didi.study.mbg.model.Question;
import com.didi.study.mbg.model.QuestionExample;
import com.didi.study.service.PageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/5/1 0001 下午 16:45
 */
@Service
public class PageInfoServiceImpl implements PageInfoService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> searchAll() {
        /*
        此处有坑：因为字段类型有text类型，映射文件xml中无法映射只能使用selectByExampleWithBLOBs或者updateByExampleWithBLOBs
        不能使用selectByExample或者updateByExample
        */
        QuestionExample questionExample = new QuestionExample();
        return questionMapper.selectByExampleWithBLOBs(questionExample);
    }
}
