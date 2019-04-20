package com.magicmirror.dao;

import com.magicmirror.entity.VoiceType;

public interface VoiceTypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(VoiceType record);

    int insertSelective(VoiceType record);

    VoiceType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(VoiceType record);

    int updateByPrimaryKey(VoiceType record);
}