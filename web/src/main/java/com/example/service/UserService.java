package com.example.service;

import com.example.db.entity.UserPO;
import com.example.model.resp.Response;

public interface UserService {
    Response<UserPO> queryByName(String username);

    Response<UserPO>  queryByEmail(String email);

}
