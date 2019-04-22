package com.jeesite.modules.function.dao;

import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.function.entity.VoiceRecord;

@MyBatisDao
public interface VoiceRecordDao {
    int deleteByPrimaryKey(Integer recordId);

    int insert(VoiceRecord record);

    int insertSelective(VoiceRecord record);

    VoiceRecord selectByPrimaryKey(Integer recordId);

    int updateByPrimaryKeySelective(VoiceRecord record);

    int updateByPrimaryKeyWithBLOBs(VoiceRecord record);

    int updateByPrimaryKey(VoiceRecord record);
}