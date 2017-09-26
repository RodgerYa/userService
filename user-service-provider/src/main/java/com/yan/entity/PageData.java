package com.yan.entity;

import lombok.Data;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Data
public class PageData {
    private Integer total;
    private Integer currentPage;
    private Integer pageIndex;
}
