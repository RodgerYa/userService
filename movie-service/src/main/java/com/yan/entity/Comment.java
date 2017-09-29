package com.yan.entity;

import lombok.Data;

@Data
public class Comment {

    private Integer id;

    private String movieid;

    private String userid;

    private Integer vote;

    private String comment;

    private String userName;

}