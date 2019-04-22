/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.device.entity.DeviceInfo;

/**
 * 设备DAO接口
 * @author arnowsx
 * @version 2019-04-21
 */
@MyBatisDao
public interface DeviceInfoDao extends CrudDao<DeviceInfo> {
	void insertDeviceInfo(DeviceInfo entity);
}