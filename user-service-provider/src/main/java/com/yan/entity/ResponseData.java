package com.yan.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Data
public class ResponseData<T> {
    private List<T> data;
    private String message="SUCCESS";

    public ResponseData(){

    }

    public ResponseData(List<T> data) {
        this.data = data;
    }

    public ResponseData(List<T> data, String message) {
        this.data = data;
        this.message = message;
    }
}