package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int countNewUser(@Param("currentTime") String  currentTime, @Param("beforeTime")String beforeTime);//指定时间段内注册用户数量

    List<User> indexUsers(int maxSize);//首页指定条数据

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}