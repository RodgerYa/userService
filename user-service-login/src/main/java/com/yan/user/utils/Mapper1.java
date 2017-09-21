package com.yan.user.utils;

import com.yan.user.Entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by yanwenbo on 2017-09-19.
 */
@Repository
public interface Mapper1 {
    @Select("select * from user where id_=#{id}")
    @Results({
            @Result(property = "id",column = "id_"),
            @Result(property = "username",column = "username_"),
            @Result(property = "password",column = "password_")
    })
    User getUserByID(@Param("id") String id);

    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id_"),
            @Result(property = "username",column = "username_"),
            @Result(property = "password",column = "password_")
    })
    List<User> getAll();

    @Select("select * from user where username_=#{name}")
    @Results({
            @Result(property = "id",column = "id_"),
            @Result(property = "username",column = "username_"),
            @Result(property = "password",column = "password_")
    })
    User getUserByName(@Param("name") String name);



}
