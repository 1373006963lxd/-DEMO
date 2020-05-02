package com.didi.study.mbg.mapper;


import com.didi.study.mbg.model.Question;
import com.didi.study.mbg.model.QuestionExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface QuestionExtMapper {
    List<Question> selectByExampleWithRowbounds(QuestionExample example, RowBounds rowBounds);

}