package com.ws.xianbao.server.service.impl;

import com.ws.xianbao.bean.Admin;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;
import com.ws.xianbao.mapper.AdminMapper;
import com.ws.xianbao.mapper.ThingsMapper;
import com.ws.xianbao.mapper.UserMapper;
import com.ws.xianbao.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ThingsMapper thingsMapper;
    @Override
    public Admin adminLogin(String account,String password){
        Admin admin = adminMapper.selectByAccount(account);
        if (null != admin && password.equals(admin.getPassword()))
            return admin;
        return null;
    }

    @Override
    public int newUserCount() {
        Long currentTime = new Date().getTime();
        Long beforeTime = currentTime - 7 * 24 * 60 * 60 * 1000;
        return userMapper.countNewUser(currentTime+"",beforeTime+"");
    }

    @Override
    public int newThingsCount() {
        Long currentTime = new Date().getTime();
        Long beforeTime = currentTime - 7 * 24 * 60 * 60 * 1000;
        return thingsMapper.countNewThing(currentTime+"",beforeTime+"");
    }

    @Override
    public int waitThingsCount() {
        return thingsMapper.waitThingsCount();
    }

    @Override
    public int passThingsCount() {
        return thingsMapper.passThingsCount();
    }

    @Override
    public int deniedThingsCount() {
        return thingsMapper.deniedThingsCount();
    }

    @Override
    public List<Things> indexThings() {
        return thingsMapper.indexThings(6);
    }

    @Override
    public List<Things> allThings(String type) {
        if (Integer.parseInt(type)<2)
        return thingsMapper.allThings(type);
        else{
            return thingsMapper.allThings2("2", "3");//通过有两种状态
        }
    }

    @Override
    public List<User> indexUsers() {
        return userMapper.indexUsers(6);
    }

    @Override
    public int passThings(String thingsId) {
        return thingsMapper.passThings(thingsId,"2");
    }

    @Override
    public int denideThings(String thingsId) {
        return thingsMapper.denideThings(thingsId,"1");
    }

    @Override
    public List<User> allUsers() {
        return userMapper.allUsers();
    }
}
