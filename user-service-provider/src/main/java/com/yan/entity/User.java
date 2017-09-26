package com.yan.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Data
public class User {
    private String id;
    private String name;
    private Date birthday;
    private String phone;
    private Double amount;

    public User(String id, String name, Date birthday, String phone, Double amount) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.amount = amount;
    }

    public User(){

    }
}
