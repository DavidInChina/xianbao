package com.ws.xianbao.server.service;

import com.ws.xianbao.bean.Admin;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;

import java.util.List;

public interface AdminService {
    public Admin adminLogin(String account, String password);

    public int newUserCount();

    public int newThingsCount();

    public int waitThingsCount();//待审核物品数

    public int passThingsCount();//审核通过数量

    public int deniedThingsCount();//拒绝数量

    public List<Things> indexThings();

    public List<Things> allThings(String type);//物品状态，0待审核，1审核拒绝，2待竞价，3已完成

    public List<User> indexUsers();

    public int passThings(String thingsId);//审核通过


    public int denideThings(String thingsId);//

    public List<User> allUsers();
}
