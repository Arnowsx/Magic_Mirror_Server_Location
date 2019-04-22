package com.magicmirror.service;

import com.magicmirror.entity.DeviceType;

import java.util.List;

public interface DeviceTypeService {

    List<DeviceType> findList(DeviceType entity);

    void insert(DeviceType entity);

    void update(DeviceType entity);

    void delete(int id);
}
