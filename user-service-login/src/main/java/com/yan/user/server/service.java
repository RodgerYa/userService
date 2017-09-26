package com.yan.user.server;

import com.yan.user.Entity.RequestData;
import com.yan.user.Entity.ResponseData;
import com.yan.user.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-18.
 */
@RequestMapping("/login")
public interface service {

    @RequestMapping(value = "/getUserByID/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserByID(
            @PathVariable(value = "id") String id);

    @ResponseBody
    @RequestMapping(value = "/getUserList",method = RequestMethod.GET)
    public ResponseData getUserList();

    @ResponseBody
    @RequestMapping(value = "/validate",method = RequestMethod.POST)
    public ResponseData ValidateUser(@RequestBody RequestData requestData);
}
