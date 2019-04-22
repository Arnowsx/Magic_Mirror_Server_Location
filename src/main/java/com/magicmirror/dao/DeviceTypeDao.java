package com.magicmirror.dao;

import com.magicmirror.entity.DeviceType;

import java.util.List;

public interface DeviceTypeDao {
    List<DeviceType> findList(DeviceType entity);

    int deleteByPrimaryKey(Integer typeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);

    void delete(int id);
}