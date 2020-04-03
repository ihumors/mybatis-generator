package com.example.service.impl;

import com.example.db.entity.UserPO;
import com.example.model.resp.Response;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Response<UserPO> queryByName(String username) {
        return Response.success(userRepository.queryByName(username));
    }

    @Override
    public Response<UserPO> queryByEmail(String email) {
        return Response.success(userRepository.queryByEmail(email));
    }


}
