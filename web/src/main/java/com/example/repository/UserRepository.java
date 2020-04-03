package com.example.repository;

import com.example.db.entity.UserExample;
import com.example.db.entity.UserPO;
import com.example.db.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserRepository {
    @Resource
    private UserMapper userMapper;

    public UserPO queryByName(String username){
        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        return userMapper.selectByExample(example).stream().findFirst().orElse(null);
    }

    public UserPO queryByEmail(String email){
        UserExample example=new UserExample();
        example.createCriteria().andUsernameEqualTo(email);
        return userMapper.selectByExample(example).stream().findFirst().orElse(null);
    }

}
