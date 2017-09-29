package com.yan.mapper;

import com.yan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yanwenbo on 2017-09-22.
 */
@Mapper
@Repository
public interface UserMapper {

    public User selectByID (String id);

    public List<User> selectUserList();

    public void insert(User user);

    public void deleteUser(String id);

    public Integer countByUser();

    public void updateUser(User user);

    public User selectUserByName(String username);
}
