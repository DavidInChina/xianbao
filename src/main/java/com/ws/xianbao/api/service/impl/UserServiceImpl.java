package com.ws.xianbao.api.service.impl;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.Price;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;
import com.ws.xianbao.mapper.PriceMapper;
import com.ws.xianbao.mapper.ThingsMapper;
import com.ws.xianbao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Autowired
    private ThingsMapper thingsMapper;

    @Autowired
    private PriceMapper priceMapper;

    @Override
    public int register(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User login(String account, String password) {
        User user = userMapper.selectByAccount(account);
        if (null != user && user.getPassword().equals(password)) {
            String lastTime = new Date().getTime() + "";
            userMapper.countLogin(user.getId(), lastTime);//更新上次登录时间
            return user;
        }
        return null;
    }

    @Override
    public int publishThings(Things things) {
        return thingsMapper.insertSelective(things);
    }

    @Override
    public List<Things> thingsList(String userId, int type) {//0是自己的物品列表，1是非自己的物品列表(待竞价)
        if (type == 0) {
            return thingsMapper.ownThingsList(userId);
        }else{
            return thingsMapper.normalThingsList(userId);
        }
    }

    @Override
    public int givePrice(String userId, String thingsId, String price,String priceDes) {
        User user = userMapper.selectByPrimaryKey(userId);
        Price price1 = new Price();
        price1.setId(UUID.randomUUID().toString());
        price1.setUserid(userId);
        price1.setUsername(user.getUsername());
        price1.setUserhead(user.getUserhead());
        price1.setThingsid(thingsId);
        price1.setPrice(price);
        price1.setPricedes(priceDes);
        String time = new Date().getTime() + "";
        price1.setPricetime(time);
        return priceMapper.insert(price1);
    }

    @Override
    public int downThings(String userId, String thingsId, String priceid) {
        Things things = thingsMapper.selectByPrimaryKey(thingsId);
        if (things.getId().equals(userId)) {
            things.setPriceid(priceid);
            things.setThingsstatus("3");
            return thingsMapper.updateByPrimaryKey(things);
        }
        return 0;
    }

    @Override
    public User getUserInfo(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<Price> priceList(String userId, String thingsId) {
        Things things = thingsMapper.selectByPrimaryKey(thingsId);
        if (userId.equals(things.getId())) {
            return priceMapper.priceList(thingsId);
        }
        return new ArrayList<>();//不是物品发布者获取不到竞价列表，应该报错
    }

}
