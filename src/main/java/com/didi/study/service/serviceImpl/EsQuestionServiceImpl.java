package com.didi.study.service.serviceImpl;

import com.didi.study.Repository.EsQuestionRepository;
import com.didi.study.dto.EsQuestion;
import com.didi.study.mbg.mapper.QuestionMapper;
import com.didi.study.mbg.model.Question;
import com.didi.study.mbg.model.QuestionExample;
import com.didi.study.service.EsQuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 23:15
 */
@Service
public class EsQuestionServiceImpl implements EsQuestionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsQuestionServiceImpl.class);

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    private EsQuestionRepository esQuestionRepository;


    @Override
    public int importAll() {
        QuestionExample questionExample = new QuestionExample();
        List<Question> questions = questionMapper.selectByExampleWithBLOBs(questionExample);
        List<EsQuestion> esQuestions = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            EsQuestion es = new EsQuestion();
            BeanUtils.copyProperties(questions.get(i), es);
            esQuestions.add(es);
        }
        Iterable<EsQuestion> esProductIterable = esQuestionRepository.saveAll(esQuestions);
        Iterator<EsQuestion> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Integer id) {
        questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public EsQuestion create(Integer id) {
        EsQuestion result = null;
        Question question = questionMapper.selectByPrimaryKey(id);
        EsQuestion esQuestion = new EsQuestion();
        BeanUtils.copyProperties(question, esQuestion);
        if (esQuestion != null) {
            result = esQuestionRepository.save(esQuestion);
        }
        return result;
    }

    @Override
    public void delete(List<Integer> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            for (Integer id : ids) {
                questionMapper.deleteByPrimaryKey(id);
            }
        }
    }

    @Override
    public Page<EsQuestion> search(String title, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return esQuestionRepository.findByTitleOrTagOrDescription(title, title, title, pageable);
    }
}
