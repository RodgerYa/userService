package com.yan.service;

import com.yan.entity.ResponseData;
import com.yan.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by yanwenbo on 2017-09-29.
 */
@FeignClient(name = "user-service-provider")
public interface UserFeignClient {

    @GetMapping(value = "/user/getUserByID/{id}")
    public ResponseData<User> getUserByID(@PathVariable("id") String id);

}
