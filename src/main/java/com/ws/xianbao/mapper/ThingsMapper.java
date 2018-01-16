package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThingsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Things record);

    int countNewThing(@Param("currentTime") String  currentTime, @Param("beforeTime")String beforeTime);//指定时间段内注册用户数量

    List<Things> indexThings(int maxSize);//首页指定条数据


    int insertSelective(Things record);

    Things selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Things record);

    int updateByPrimaryKey(Things record);
}