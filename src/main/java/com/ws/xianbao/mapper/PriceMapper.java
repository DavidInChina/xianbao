package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.Price;

import java.util.List;

public interface PriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Price record);

    int insertSelective(Price record);

    Price selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);


    List<Price> priceList(String thingsId);//用户获取自己物品竞价列表
}