package com.magicmirror.dao;

import com.magicmirror.entity.DeviceLoginInfo;

public interface DeviceLoginInfoDao {
    int deleteByPrimaryKey(String deviceLoginId);

    int insert(DeviceLoginInfo record);

    int insertSelective(DeviceLoginInfo record);

    DeviceLoginInfo selectByPrimaryKey(String deviceLoginId);

    int updateByPrimaryKeySelective(DeviceLoginInfo record);

    int updateByPrimaryKey(DeviceLoginInfo record);
}