package com.didi.study.dto;

import lombok.Data;

/**
 * Created by codedrinker on 2019/8/2.
 */
@Data
public class HotTagDTO implements Comparable {
    private String name;
    private Integer priority;

    //比较规则
    @Override
    public int compareTo(Object o) {
        return this.getPriority() - ((HotTagDTO) o).getPriority();
    }
}
