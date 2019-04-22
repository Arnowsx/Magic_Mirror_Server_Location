/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.note.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.note.entity.Note;
import com.jeesite.modules.note.dao.NoteDao;

/**
 * 日志Service
 * @author arnowsx
 * @version 2019-04-21
 */
@Service
@Transactional(readOnly=true)
public class NoteService extends CrudService<NoteDao, Note> {
	
	/**
	 * 获取单条数据
	 * @param note
	 * @return
	 */
	@Override
	public Note get(Note note) {
		return super.get(note);
	}
	
	/**
	 * 查询分页数据
	 * @param note 查询条件
	 * @param note.page 分页对象
	 * @return
	 */
	@Override
	public Page<Note> findPage(Note note) {
		return super.findPage(note);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param note
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Note note) {
		if(note.getNoteId() == null || note.getNoteId().equals("")){
			dao.insertNote(note);
		}else {
			super.save(note);
		}
	}
	
	/**
	 * 更新状态
	 * @param note
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Note note) {
		super.updateStatus(note);
	}
	
	/**
	 * 删除数据
	 * @param note
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Note note) {
		super.delete(note);
	}
	
}