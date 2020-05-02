package com.didi.study.Repository;

import com.didi.study.dto.EsQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 23:02
 */
public interface EsQuestionRepository extends ElasticsearchRepository<EsQuestion, Integer> {

    Page<EsQuestion> findByTitleOrTagOrDescription(String title, String tag, String description, Pageable page);
}
