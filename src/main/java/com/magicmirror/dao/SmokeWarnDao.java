package com.magicmirror.dao;

import com.magicmirror.entity.SmokeWarn;

public interface SmokeWarnDao {
    int deleteByPrimaryKey(Integer eventId);

    int insert(SmokeWarn record);

    int insertSelective(SmokeWarn record);

    SmokeWarn selectByPrimaryKey(Integer eventId);

    int updateByPrimaryKeySelective(SmokeWarn record);

    int updateByPrimaryKey(SmokeWarn record);
}