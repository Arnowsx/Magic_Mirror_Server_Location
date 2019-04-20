package com.magicmirror.dao;

import com.magicmirror.entity.DeviceLoginLog;

public interface DeviceLoginLogDao {
    int deleteByPrimaryKey(Integer eventId);

    int insert(DeviceLoginLog record);

    int insertSelective(DeviceLoginLog record);

    DeviceLoginLog selectByPrimaryKey(Integer eventId);

    int updateByPrimaryKeySelective(DeviceLoginLog record);

    int updateByPrimaryKey(DeviceLoginLog record);
}