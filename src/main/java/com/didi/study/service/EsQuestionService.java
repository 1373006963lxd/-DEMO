package com.didi.study.service;

import com.didi.study.dto.EsQuestion;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EsQuestionService {
    /**
     * 从数据库中导入所有问题到ES
     */
    int importAll();

    /**
     * 根据id删除问题
     */
    void delete(Integer id);

    /**
     * 根据id创建问题
     */
    EsQuestion create(Integer id);

    /**
     * 批量删除问题
     */
    void delete(List<Integer> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsQuestion> search(String title ,Integer pageNum, Integer pageSize);
}
