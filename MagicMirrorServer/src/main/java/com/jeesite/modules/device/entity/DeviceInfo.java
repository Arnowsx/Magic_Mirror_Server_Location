/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 设备Entity
 * @author arnowsx
 * @version 2019-04-21
 */
@Table(name="device_info_table", alias="a", columns={
		@Column(name="device_id", attrName="deviceId", label="设备ID", isPK=true),
		@Column(name="name", attrName="name", label="设备名称", queryType=QueryType.LIKE),
		@Column(name="device_mac", attrName="deviceMac", label="设备MAC地址"),
		@Column(name="device_type", attrName="deviceType", label="设备类型"),
		@Column(name="device_status", attrName="deviceStatus", label="设备状态"),
	}, orderBy="a.device_id DESC"
)
public class DeviceInfo extends DataEntity<DeviceInfo> {
	
	private static final long serialVersionUID = 1L;
	private Long deviceId;		// 设备ID
	private String name;		// 设备名称
	private String deviceMac;		// 设备MAC地址
	private Long deviceType;		// 设备类型
	private String deviceStatus;		// 设备状态
	
	public DeviceInfo() {
		this(null);
	}

	public DeviceInfo(String id){
		super(id);
	}
	
	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	@NotBlank(message="设备名称不能为空")
	@Length(min=0, max=20, message="设备名称长度不能超过 20 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotBlank(message="设备MAC地址不能为空")
	@Length(min=0, max=20, message="设备MAC地址长度不能超过 20 个字符")
	public String getDeviceMac() {
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	
	@NotNull(message="设备类型不能为空")
	public Long getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(Long deviceType) {
		this.deviceType = deviceType;
	}
	
	@NotBlank(message="设备状态不能为空")
	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}
	
}