package com.yan.controller;

import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.entity.User;
import com.yan.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwenbo on 2017-09-28.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserByID/{id}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryUserByID(@PathVariable String id){
//        String id = requestData.getUserID();
        User user = userService.queryUserByID(id);
        List<User> userList =new ArrayList<>();
        userList.add(user);
        return new ResponseData<User>(userList);
    }

    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryUserList(){
        List<User> userList = userService.queryUserList();
        return new ResponseData(userList);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData AddUser(@RequestBody RequestData requestData){
        User user =null;
        BeanUtils.copyProperties(requestData,user);
        userService.AddUser(user);
        return new ResponseData();
    }

    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    @ResponseBody
    public ResponseData loginValidate(@RequestBody RequestData requestData){
        return userService.validateUser(requestData);
    }


//    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
//    public ResponseData removeUser(@RequestBody RequestData requestData){
//        String id = requestData.getUserID();
//
//        return new ResponseData();
//    }
//
//    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
//    public ResponseData updateUser(@RequestBody RequestData requestData){
//        return null;
//    }
//
//    public Integer countByUser(){
//        return null;
//    }
}
