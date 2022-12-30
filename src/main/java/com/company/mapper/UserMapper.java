package com.company.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public int userCount(String UserId);
}
