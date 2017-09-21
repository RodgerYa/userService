package com.yan.user.Entity;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-20.
 */
public class ResponseData<T> {
    private List<T> data;
    private String message = StatusEnum.SUCCESS.getMessage();
    private String status = StatusEnum.SUCCESS.getCode();

    public ResponseData(){
    }

    public ResponseData(List<T> data){
        this.data = data;
    }

    public ResponseData(List<T> data,String message){
        this.data = data;
        this.message = message;
    }

    public ResponseData(String status,String message ) {
        this.message = message;
        this.status = status;
    }

    public ResponseData(List<T> data, String message, String status){
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
