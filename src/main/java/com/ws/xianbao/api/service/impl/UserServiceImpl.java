package com.ws.xianbao.api.service.impl;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.User;
import com.ws.xianbao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }
}