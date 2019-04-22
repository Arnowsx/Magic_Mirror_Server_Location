package com.magicmirror.dao;

import com.magicmirror.entity.DeviceInfo;

import java.util.List;

public interface DeviceInfoDao {

    List<DeviceInfo> findList(DeviceInfo entity);

    void insert(DeviceInfo entity);

    void update(DeviceInfo entity);

    void delete(int id);

    boolean isOnline(int id);
}