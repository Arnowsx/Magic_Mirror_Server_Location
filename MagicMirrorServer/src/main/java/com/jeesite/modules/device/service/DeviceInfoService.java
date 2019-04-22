/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.device.entity.DeviceInfo;
import com.jeesite.modules.device.dao.DeviceInfoDao;

/**
 * 设备Service
 * @author arnowsx
 * @version 2019-04-21
 */
@Service
@Transactional(readOnly=true)
public class DeviceInfoService extends CrudService<DeviceInfoDao, DeviceInfo> {
	
	/**
	 * 获取单条数据
	 * @param deviceInfo
	 * @return
	 */
	@Override
	public DeviceInfo get(DeviceInfo deviceInfo) {
		return super.get(deviceInfo);
	}
	
	/**
	 * 查询分页数据
	 * @param deviceInfo 查询条件
	 * @param deviceInfo.page 分页对象
	 * @return
	 */
	@Override
	public Page<DeviceInfo> findPage(DeviceInfo deviceInfo) {
		return super.findPage(deviceInfo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param deviceInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(DeviceInfo deviceInfo) {
		if(deviceInfo.getDeviceId() == null || deviceInfo.getDeviceId().equals("")){
			dao.insertDeviceInfo(deviceInfo);
		}else {
			super.save(deviceInfo);
		}
	}
	
	/**
	 * 更新状态
	 * @param deviceInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(DeviceInfo deviceInfo) {
		super.updateStatus(deviceInfo);
	}
	
	/**
	 * 删除数据
	 * @param deviceInfo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(DeviceInfo deviceInfo) {
		super.delete(deviceInfo);
	}
	
}