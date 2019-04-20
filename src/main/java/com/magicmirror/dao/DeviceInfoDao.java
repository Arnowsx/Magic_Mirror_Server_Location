package com.magicmirror.dao;

import com.magicmirror.entity.DeviceInfo;

public interface DeviceInfoDao {
    int deleteByPrimaryKey(Integer deviceId);

    int insert(DeviceInfo record);

    int insertSelective(DeviceInfo record);

    DeviceInfo selectByPrimaryKey(Integer deviceId);

    int updateByPrimaryKeySelective(DeviceInfo record);

    int updateByPrimaryKey(DeviceInfo record);
}