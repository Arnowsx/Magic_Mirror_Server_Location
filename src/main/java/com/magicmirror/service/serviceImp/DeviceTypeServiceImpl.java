package com.magicmirror.service.serviceImp;

import com.magicmirror.dao.DeviceTypeDao;
import com.magicmirror.entity.DeviceType;
import com.magicmirror.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceImpl implements DeviceTypeService {

    @Autowired
    private DeviceTypeDao dao;

    @Override
    public List<DeviceType> findList(DeviceType entity) {
        return dao.findList(entity);
    }

    @Override
    public void insert(DeviceType entity) {
        dao.insert(entity);
    }

    @Override
    public void update(DeviceType entity) {
        dao.updateByPrimaryKey(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
