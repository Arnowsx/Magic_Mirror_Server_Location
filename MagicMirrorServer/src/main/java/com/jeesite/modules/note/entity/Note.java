/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.note.entity;

import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 日志Entity
 * @author arnowsx
 * @version 2019-04-21
 */
@Table(name="note_table", alias="a", columns={
		@Column(name="note_id", attrName="noteId", label="日志ID", isPK=true),
		@Column(name="save_time", attrName="saveTime", label="保存时间"),
		@Column(name="text", attrName="text", label="日志内容", queryType=QueryType.LIKE),
		@Column(name="device_id", attrName="deviceId", label="设备id", isUpdate=false),
	}, orderBy="a.note_id DESC"
)
public class Note extends DataEntity<Note> {
	
	private static final long serialVersionUID = 1L;
	private Long noteId;		// 日志ID
	private Date saveTime;		// 保存时间
	private String text;		// 日志内容
	private Long deviceId;		// 设备id
	
	public Note() {
		this(null);
	}

	public Note(String id){
		super(id);
	}
	
	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="保存时间不能为空")
	public Date getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	
	@Length(min=0, max=1000, message="日志内容长度不能超过 1000 个字符")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@NotNull(message="设备id不能为空")
	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	
	public Date getSaveTime_gte() {
		return sqlMap.getWhere().getValue("save_time", QueryType.GTE);
	}

	public void setSaveTime_gte(Date saveTime) {
		sqlMap.getWhere().and("save_time", QueryType.GTE, saveTime);
	}
	
	public Date getSaveTime_lte() {
		return sqlMap.getWhere().getValue("save_time", QueryType.LTE);
	}

	public void setSaveTime_lte(Date saveTime) {
		sqlMap.getWhere().and("save_time", QueryType.LTE, saveTime);
	}
	
}