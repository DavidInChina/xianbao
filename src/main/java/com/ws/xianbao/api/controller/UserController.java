package com.ws.xianbao.api.controller;

import com.ws.xianbao.api.service.UserService;
import com.ws.xianbao.bean.Price;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> addUser(String account, String password, String username, String head){
        Map<String, Object> resultMap = new HashMap<>();
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
        int result = userService.register(user);
        if (0 == result) {
            resultMap.put("code", "0");
            resultMap.put("msg", "注册成功");
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "注册失败！");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> addUser(String account,String password){
        Map<String, Object> resultMap = new HashMap<>();
        User user = userService.login(account, password);
        if (null != user) {
            resultMap.put("code", "0");
            resultMap.put("msg", "登录成功");
            resultMap.put("data", "{'userId':'"+user.getId()+"'}");
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "登录失败！");
            resultMap.put("data", "");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping(value = "/publishThings",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Map<String,Object> publishThings(String thingsname,String userid,String userHead,String username,
                                            String thingsdes,String thingimgs,String thingsprice){
        Map<String, Object> resultMap = new HashMap<>();
        Things things = new Things();
        things.setId(UUID.randomUUID().toString());
        things.setThingsname(thingsname);
        things.setUserid(userid);
        things.setUserhead(userHead);
        things.setUsername(username);
        things.setThingsdes(thingsdes);
        things.setThingsimgs(thingimgs);
        things.setThingsprice(thingsprice);
        String time = new Date().getTime() + "";
        things.setUptime(time);
        things.setThingsstatus("0");
        things.setPriceid("0");
        int result = userService.publishThings(things);
        if (result == 0) {
            resultMap.put("code", "0");
            resultMap.put("msg", "添加成功，等待审核通过");
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "添加失败！");
        }
        return resultMap;
    }


    /**
     * 首页非自己物品列表
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/thingsList", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> thingsList(String userId){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Things> things = userService.thingsList(userId,1);
            map.put("code", "0");//账号或密码错误
            map.put("msg", "获取物品列表成功");
            map.put("data", things);
        } catch (Exception e) {
            map.put("code", "1");//账号或密码错误
            map.put("msg", "获取物品列表失败");
        }
        return map;
    }

    /**
     * 自己物品列表
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/ownThingsList", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> ownThingsList(String userId){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Things> things = userService.thingsList(userId,0);
            map.put("code", "0");//账号或密码错误
            map.put("msg", "获取物品列表成功");
            map.put("data", things);
        } catch (Exception e) {
            map.put("code", "1");//账号或密码错误
            map.put("msg", "获取物品列表失败");
        }
        return map;
    }

    /**
     * 参与物品竞价
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/givePrice", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> givePrice(String userId,String thingsId,String price,String priceDes){
        Map<String, Object> resultMap = new HashMap<>();
        int result = userService.givePrice(userId,thingsId,price,priceDes);
        if (result == 0) {
            resultMap.put("code", "0");
            resultMap.put("msg", "竞价成功");
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "竞价失败！");
        }
        return resultMap;
    }

    /**
     * 用户获取自己物品竞价列表
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/priceList", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> priceList(String userId,String  thingsId){
        Map<String, Object> map = new HashMap<>();
        try {
            List<Price> things = userService.priceList(userId,thingsId);
            map.put("code", "0");//账号或密码错误
            map.put("msg", "获取竞价成功");
            map.put("data", things);
        } catch (Exception e) {
            map.put("code", "1");//账号或密码错误
            map.put("msg", "获取竞价列表失败");
        }
        return map;
    }


    /**
     * 发布者确认竞价成功
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/downThings", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> downThings(String userId,String thingsId,String priceid){
        Map<String, Object> resultMap = new HashMap<>();
        int result = userService.downThings(userId,thingsId,priceid);
        if (result == 0) {
            resultMap.put("code", "0");
            resultMap.put("msg", "确认成功");
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "确认失败！");
        }
        return resultMap;
    }

    /**
     * 发布者确认竞价成功
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> getUserInfo(String userId){
        Map<String, Object> resultMap = new HashMap<>();
        User user = userService.getUserInfo(userId);
        if (user != null) {
            resultMap.put("code", "0");
            resultMap.put("msg", "确认成功");
            resultMap.put("data", user);
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "确认失败！");
            resultMap.put("data", "");
        }
        return resultMap;
    }
}
