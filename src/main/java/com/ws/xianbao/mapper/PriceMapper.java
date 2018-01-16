package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.Price;

public interface PriceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Price record);

    int insertSelective(Price record);

    Price selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Price record);

    int updateByPrimaryKey(Price record);
}