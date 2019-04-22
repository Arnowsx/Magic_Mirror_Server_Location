/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.device.entity.DeviceType;
import com.jeesite.modules.device.dao.DeviceTypeDao;

/**
 * 设备类型Service
 * @author arnowsx
 * @version 2019-04-21
 */
@Service
@Transactional(readOnly=true)
public class DeviceTypeService extends CrudService<DeviceTypeDao, DeviceType> {
	
	/**
	 * 获取单条数据
	 * @param deviceType
	 * @return
	 */
	@Override
	public DeviceType get(DeviceType deviceType) {
		return super.get(deviceType);
	}
	
	/**
	 * 查询分页数据
	 * @param deviceType 查询条件
	 * @param deviceType.page 分页对象
	 * @return
	 */
	@Override
	public Page<DeviceType> findPage(DeviceType deviceType) {
		return super.findPage(deviceType);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param deviceType
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DeviceType deviceType) {
		if(deviceType.getTypeId() == null || deviceType.getTypeId().equals("")){
			dao.insertDeviceType(deviceType);
		}else {
			super.save(deviceType);
		}
	}
	
	/**
	 * 更新状态
	 * @param deviceType
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DeviceType deviceType) {
		super.updateStatus(deviceType);
	}
	
	/**
	 * 删除数据
	 * @param deviceType
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DeviceType deviceType) {
		super.delete(deviceType);
	}
	
}