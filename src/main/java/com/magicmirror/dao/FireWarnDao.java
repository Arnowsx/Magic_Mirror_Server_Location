package com.magicmirror.dao;

import com.magicmirror.entity.FireWarn;

public interface FireWarnDao {
    int deleteByPrimaryKey(Integer eventId);

    int insert(FireWarn record);

    int insertSelective(FireWarn record);

    FireWarn selectByPrimaryKey(Integer eventId);

    int updateByPrimaryKeySelective(FireWarn record);

    int updateByPrimaryKey(FireWarn record);
}