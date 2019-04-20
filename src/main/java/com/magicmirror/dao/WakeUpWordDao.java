package com.magicmirror.dao;

import com.magicmirror.entity.WakeUpWord;

public interface WakeUpWordDao {
    int deleteByPrimaryKey(Integer wordId);

    int insert(WakeUpWord record);

    int insertSelective(WakeUpWord record);

    WakeUpWord selectByPrimaryKey(Integer wordId);

    int updateByPrimaryKeySelective(WakeUpWord record);

    int updateByPrimaryKeyWithBLOBs(WakeUpWord record);

    int updateByPrimaryKey(WakeUpWord record);
}