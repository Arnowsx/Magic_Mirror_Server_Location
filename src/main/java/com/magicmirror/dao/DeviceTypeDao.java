package com.magicmirror.dao;

import com.magicmirror.entity.DeviceType;

public interface DeviceTypeDao {
    int deleteByPrimaryKey(Integer typeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}