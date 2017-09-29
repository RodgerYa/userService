package com.yan.service;

import com.yan.entity.RequestData;
import com.yan.entity.ResponseData;
import com.yan.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-22.
 */

public interface UserService {

    public User queryUserByID(String id);

    public List<User> queryUserList();

    public void AddUser(User user);

    public void removeUser(String id);

    public void updateUser(User user);

    public Integer countByUser();

    public ResponseData validateUser(@RequestBody RequestData requestData);
}
