package com.ws.xianbao.server.service;

import com.ws.xianbao.bean.Admin;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;

import java.util.List;

public interface AdminService {
    public Admin adminLogin(String account, String password);

    public int newUserCount();

    public int newThingsCount();

    public List<Things> indexThings();

    public List<User> indexUsers();
}
