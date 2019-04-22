/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clock.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 闹钟Entity
 * @author arnowsx
 * @version 2019-04-21
 */
@Table(name="clock_table", alias="a", columns={
		@Column(name="clock_id", attrName="clockId", label="闹钟ID", isPK=true),
		@Column(name="time", attrName="time", label="闹钟设置时间"),
		@Column(name="status", attrName="clockStatus", label="是否启用"),
		@Column(name="device_id", attrName="deviceId", label="设备ID"),
	}, orderBy="a.clock_id DESC"
)
public class Clock extends DataEntity<Clock> {

	public enum ClockStatus{
		ENABLE,
		DISABLE;
	}
	
	private static final long serialVersionUID = 1L;
	private Long clockId;		// 闹钟ID
	private Date time;		// 闹钟设置时间
	private ClockStatus clockStatus;   //是否启用
	private Long deviceId;		// 设备ID
	
	public Clock() {
		this(null);
	}

	public Clock(String id){
		super(id);
	}
	
	public Long getClockId() {
		return clockId;
	}

	public void setClockId(Long clockId) {
		this.clockId = clockId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@NotNull(message="请确定是否启用")
	public ClockStatus getClockStatus() {
		return clockStatus;
	}

	public void setClockStatus(ClockStatus clockStatus) {
		this.clockStatus = clockStatus;
	}

	@NotNull(message="设备ID不能为空")
	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
}