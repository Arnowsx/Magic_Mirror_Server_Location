package com.magicmirror.dao;

import com.magicmirror.entity.Clock;

public interface ClockDao {
    int deleteByPrimaryKey(Integer clockId);

    int insert(Clock record);

    int insertSelective(Clock record);

    Clock selectByPrimaryKey(Integer clockId);

    int updateByPrimaryKeySelective(Clock record);

    int updateByPrimaryKey(Clock record);
}