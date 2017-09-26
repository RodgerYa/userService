package com.yan.entity;

import lombok.Data;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-25.
 */
@Data
public class ResponseData<T> {
    private List<T> data;
    private String status="0000";
    private String message="SUCCESS";

    public ResponseData(List<T> data, String status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public ResponseData(List<T> data) {
        this.data = data;
    }

    public ResponseData(){

    }

}
