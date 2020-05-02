package com.didi.study.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @auther li xiao dong
 * @date 2020/5/2 0002 下午 22:56
 */
@Data
@Document(indexName = "user", type = "question",shards = 1,replicas = 0)
public class EsQuestion implements Serializable {
    @Id
    private Integer id;

    @ApiModelProperty(name = "不需要中文分词字段")
    @Field(type = FieldType.Keyword)
    private String title;

    private Long gmtCreate;

    private Long gmtModified;

    @ApiModelProperty(name = "需要中文分词字段")
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private Integer creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

    private String description;
}
