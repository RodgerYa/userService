package com.yan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yanwenbo on 2017-09-28.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestData {

    private String movieID;

    private String movieName;

    private String comment;

    private Integer vote;

    private String userName;

    private String userID;

    private String releaseDate;

    @Override
    public String toString() {
        return "RequestData{" +
                "movieID='" + movieID + '\'' +
                ", movieName='" + movieName + '\'' +
                ", comment='" + comment + '\'' +
                ", vote=" + vote +
                ", userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
