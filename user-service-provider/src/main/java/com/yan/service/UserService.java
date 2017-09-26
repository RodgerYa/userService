package com.yan.service;

import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-22.
 */
public interface UserService {
    @RequestMapping(value = "/getUserByID",method = RequestMethod.GET)
    public ResponseData queryUserByID(@RequestBody RequestData requestData);

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResponseData queryUserList();

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseData AddUser(@RequestBody RequestData requestData);

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    public ResponseData removeUser(@RequestBody RequestData requestData);

    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
    public ResponseData updateUser(@RequestBody RequestData requestData);

    public Integer countByUser();
}
