package com.yan.user.server;

import com.yan.user.Entity.RequestData;
import com.yan.user.Entity.ResponseData;
import com.yan.user.Entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-18.
 */
@RequestMapping("/user")
public interface service {

    @RequestMapping(value = "/getUserByID/{id}")
    @ResponseBody
    public User getUserByID(
            @PathVariable(value = "id") String id);

    @ResponseBody
    @RequestMapping(value = "/getAll")
    public List<User> getUserList();

    @ResponseBody
    @RequestMapping(value = "/validate")
    public ResponseData ValidateUser(@RequestBody RequestData requestData);
}
