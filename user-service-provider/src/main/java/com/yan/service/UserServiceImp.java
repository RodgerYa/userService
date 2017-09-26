package com.yan.service;

import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.entity.User;
import com.yan.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Service
@RequestMapping(value = "/user")
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @RequestMapping(value = "/getUserByID",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData queryUserByID(@RequestBody RequestData requestData) {
        String id = requestData.getUserID();
        if (id == null || id.length()==0){
            return null;
        }
        User user = userMapper.selectByID(id);
        if(user == null) {
            return null;
        }
        List<User> userList=new ArrayList<User>();
        userList.add(user);
        return new ResponseData(userList);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResponseData queryUserList() {
        List<User> userList = userMapper.selectUserList();
        return new ResponseData(userList);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseData AddUser(@RequestBody RequestData requestData) {
        User user = new User();
        BeanUtils.copyProperties(requestData,user);
        userMapper.insert(user);
        return new ResponseData();
    }

    @RequestMapping(value = "/removeUser",method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseData removeUser(@RequestBody RequestData requestData) {
        String id = requestData.getUserID();
        userMapper.deleteUser(id);
        return new ResponseData();
    }


    @RequestMapping(value = "/modifyUser",method = RequestMethod.POST)
    @ResponseBody
    @Override
    public ResponseData updateUser(@RequestBody RequestData requestData) {
        User user = new User();
        BeanUtils.copyProperties(requestData,user);
        userMapper.updateUser(user);
        return new ResponseData();
    }

    @Override
    public Integer countByUser() {
        return null;
    }
}
