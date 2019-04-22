package com.magicmirror.dao;

import com.magicmirror.entity.Clock;

import java.util.List;

public interface ClockDao {
    List<Clock> findList(Clock entity);

    int deleteByPrimaryKey(Integer clockId);

    int insert(Clock record);

    int insertSelective(Clock record);

    Clock selectByPrimaryKey(Integer clockId);

    int updateByPrimaryKeySelective(Clock record);

    int updateByPrimaryKey(Clock record);

    void delete(int clockId);
}