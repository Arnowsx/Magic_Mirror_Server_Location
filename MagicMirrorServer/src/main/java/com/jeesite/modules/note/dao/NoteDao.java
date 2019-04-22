/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.note.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.note.entity.Note;

/**
 * 日志DAO接口
 * @author arnowsx
 * @version 2019-04-21
 */
@MyBatisDao
public interface NoteDao extends CrudDao<Note> {
	void insertNote(Note entity);
}