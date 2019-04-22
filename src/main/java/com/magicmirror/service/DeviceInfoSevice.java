package com.magicmirror.service;

import com.magicmirror.entity.DeviceInfo;

import java.util.List;

public interface DeviceInfoSevice {

    List<DeviceInfo> findList(DeviceInfo entity);

    void insert(DeviceInfo entity);

    void update(DeviceInfo entity);

    void delete(int id);

    boolean isOnline(int id);
}
