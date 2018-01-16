package com.ws.xianbao.api.controller;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public int addUser(String account,String password,String username,String head){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setAccount(account);
        user.setPassword(password);
        user.setUsername(username);
        user.setUserhead(head);
        String time = new Date().getTime() + "";
        user.setRegtime(time);
        user.setLasttime(time);
        user.setUsertype("0");
        user.setPricecount("0");
        user.setPublishcount("0");
        user.setArea("122334");//暂时写死用户位置
        return userService.register(user);
    }
}
