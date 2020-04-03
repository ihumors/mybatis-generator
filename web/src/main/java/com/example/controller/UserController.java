package com.example.controller;

import com.example.db.entity.UserPO;
import com.example.model.resp.Response;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/queryByName")
    public Response<UserPO> queryByName(String username) {
        return userService.queryByName(username);
    }


}
