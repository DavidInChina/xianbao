package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.Price;
import com.ws.xianbao.bean.Things;
import com.ws.xianbao.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThingsMapper {
    int deleteByPrimaryKey(String id);

    int insert(Things record);

    int countNewThing(@Param("currentTime") String  currentTime, @Param("beforeTime")String beforeTime);//指定时间段内注册用户数量

    List<Things> indexThings(int maxSize);//首页指定条数据

    List<Things> allThings(String type);//根据状态获取所有物品

    List<Things> normalThingsList(String userId);//获取非该用户所有待竞价物品

    List<Things> ownThingsList(String userId);//获取该用户所有物品

    List<Things> allThings2(@Param("type1")String type1,@Param("type2")String type2);//根据状态获取所有物品

    int insertSelective(Things record);

    Things selectByPrimaryKey(String id);


    int passThings(@Param("thingsId") String  thingsId, @Param("thingType")String thingType );

    int denideThings(@Param("thingsId") String  thingsId, @Param("thingType")String thingType);

    int updateByPrimaryKeySelective(Things record);

    int updateByPrimaryKey(Things record);


    public int waitThingsCount();//待审核物品数

    public int passThingsCount();//审核通过数量

    public int deniedThingsCount();//拒绝数量
}