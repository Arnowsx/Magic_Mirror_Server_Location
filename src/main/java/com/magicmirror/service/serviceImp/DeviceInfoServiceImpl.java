package com.magicmirror.service.serviceImp;

import com.magicmirror.dao.DeviceInfoDao;
import com.magicmirror.entity.DeviceInfo;
import com.magicmirror.service.DeviceInfoSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceInfoServiceImpl implements DeviceInfoSevice {

    @Autowired
    private DeviceInfoDao dao;

    @Override
    public List<DeviceInfo> findList(DeviceInfo entity) {
        return dao.findList(entity);
    }

    @Override
    public void insert(DeviceInfo entity) {
        dao.insert(entity);
    }

    @Override
    public void update(DeviceInfo entity) {
        dao.update(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public boolean isOnline(int id) {
        return dao.isOnline(id);
    }
}
