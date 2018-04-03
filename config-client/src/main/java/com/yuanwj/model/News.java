package com.yuanwj.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by bmk on 18-4-3.
 */
@Data
public class News {
    private Long id;

    private String title;

    private String researchDate;

    private Date createDate;

    private String link;
}

