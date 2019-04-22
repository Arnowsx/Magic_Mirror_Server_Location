/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.entity;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 设备类型Entity
 * @author arnowsx
 * @version 2019-04-21
 */
@Table(name="device_type_table", alias="a", columns={
		@Column(name="type_id", attrName="typeId", label="类型ID", isPK=true),
		@Column(name="type", attrName="type", label="设备类型"),
	}, orderBy="a.type_id DESC"
)
public class DeviceType extends DataEntity<DeviceType> {
	
	private static final long serialVersionUID = 1L;
	private Long typeId;		// 类型ID
	private String type;		// 设备类型
	
	public DeviceType() {
		this(null);
	}

	public DeviceType(String id){
		super(id);
	}
	
	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	
	@NotBlank(message="设备类型不能为空")
	@Length(min=0, max=20, message="设备类型长度不能超过 20 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}