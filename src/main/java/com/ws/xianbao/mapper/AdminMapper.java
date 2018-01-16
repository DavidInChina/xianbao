package com.ws.xianbao.mapper;

import com.ws.xianbao.bean.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(String id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String id);

    Admin selectByAccount(String account);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}