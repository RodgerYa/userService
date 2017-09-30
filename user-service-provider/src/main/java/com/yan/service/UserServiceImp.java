package com.yan.service;

import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.entity.User;
import com.yan.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public User queryUserByID(String id) {
        if (id == null || id.length()==0){
            return null;
        }
        User user = userMapper.selectByID(id);
        if(user == null) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> queryUserList() {
        List<User> userList = userMapper.selectUserList();
        return userList;
    }

    @Override
    public ResponseData validateUser(RequestData requestData){
        System.out.println(requestData);
        User user = userMapper.selectUserByName(requestData.getUserName());
        System.out.println(user);
        if (user == null) {
            return null;
        }
        if (requestData.getUserName().equals(user.getName()) && requestData.getPassword().equals(user.getPassword())){
            List<User> userList = new ArrayList<User>();
            userList.add(user);
            return new ResponseData(userList);
        } else {
            return null;
        }

    }

    @Override
    @Transactional
    public void AddUser(User user) {
        userMapper.insert(user);
    }

    @Override
    @Transactional
    public void removeUser(String id) {
        userMapper.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public Integer countByUser() {
        return null;
    }
}
