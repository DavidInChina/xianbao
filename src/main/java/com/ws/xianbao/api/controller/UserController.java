package com.ws.xianbao.api.controller;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        return userService.register(user);
    }
}
