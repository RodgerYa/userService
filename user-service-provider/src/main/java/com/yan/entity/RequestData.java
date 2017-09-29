package com.yan.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Data
public class RequestData {

    private String userID;

    private String userName;

    private String password;

    private String PhoneNumber;

    private Date birthday;

    private Double amount;
}
