package com.magicmirror.dao;

import com.magicmirror.entity.VoiceRecord;

public interface VoiceRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(VoiceRecord record);

    int insertSelective(VoiceRecord record);

    VoiceRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(VoiceRecord record);

    int updateByPrimaryKeyWithBLOBs(VoiceRecord record);

    int updateByPrimaryKey(VoiceRecord record);
}