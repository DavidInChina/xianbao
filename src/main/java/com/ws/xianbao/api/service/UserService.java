package com.ws.xianbao.api.service;

import com.ws.xianbao.bean.Price;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;

import java.util.List;

public interface UserService {
    int register(User user);

    User login(String account, String password);

    int publishThings(Things things);

    List<Things> thingsList(String userId, int type);//0是自己的物品列表，1是非自己的物品列表(待竞价)


    int givePrice(String userId, String thingsId, String price,String priceDes);


    int downThings(String userId, String thingsId, String priceid);


    User getUserInfo(String userId);

    List<Price> priceList(String userId, String thingsId);
}
