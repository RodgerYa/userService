package com.yan.user.server;

import com.yan.user.Entity.RequestData;
import com.yan.user.Entity.ResponseData;
import com.yan.user.Entity.StatusEnum;
import com.yan.user.Entity.User;
import com.yan.user.utils.Mapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanwenbo on 2017-09-18.
 */
@Controller
@RequestMapping(value="/login")
public class ServiceImp implements service,Serializable{

    @Autowired
    private Mapper1 mapper1;

    @RequestMapping(value = "/getUserByID/{id}",method= RequestMethod.GET)
    @Override
    @ResponseBody
    public User getUserByID(@PathVariable(value = "id") String id) {
        User user = mapper1.getUserByID(id);
        System.out.println(user);
        return user;
    }

    @Override
    @RequestMapping(value="/getUserList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData getUserList() {
        List<User> listUser;
        listUser = mapper1.getAll();
        return new ResponseData(listUser);
    }

    public User getUserByName(String name){
        User user =mapper1.getUserByName(name);
        System.out.println("getUserByName查询...."+user);
        return user;
    }

    @Override
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData ValidateUser(@RequestBody RequestData requestData){
        String name = requestData.getUsername();
        String password = requestData.getPassword();
        if (name == null){
            return new ResponseData(StatusEnum.BAD_REQUEST.getCode(),StatusEnum.BAD_REQUEST.getMessage());
        }

        User user = this.getUserByName(name);
        if (user == null) {
            return new ResponseData(StatusEnum.FAILURE.getCode(),StatusEnum.FAILURE.getMessage());
        }
        if (!password.equals(user.getPassword())){
            return new ResponseData(StatusEnum.PSSWORD_WORNG.getCode(),StatusEnum.PSSWORD_WORNG.getMessage());
        } else {
            List<User> userList = new ArrayList<User>();
            userList.add(user);
            return new ResponseData(userList);
        }

    }
}
