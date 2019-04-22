/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.note.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.note.entity.Note;
import com.jeesite.modules.note.service.NoteService;

/**
 * 日志Controller
 * @author arnowsx
 * @version 2019-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/note/note")
public class NoteController extends BaseController {

	@Autowired
	private NoteService noteService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Note get(Long noteId, boolean isNewRecord) {
		return noteService.get(String.valueOf(noteId), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("note:note:view")
	@RequestMapping(value = {"list", ""})
	public String list(Note note, Model model) {
		model.addAttribute("note", note);
		return "modules/note/noteList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("note:note:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Note> listData(Note note, HttpServletRequest request, HttpServletResponse response) {
		note.setPage(new Page<>(request, response));
		Page<Note> page = noteService.findPage(note);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("note:note:view")
	@RequestMapping(value = "form")
	public String form(Note note, Model model) {
		model.addAttribute("note", note);
		return "modules/note/noteForm";
	}

	/**
	 * 保存日志
	 */
	@RequiresPermissions("note:note:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Note note) {
		noteService.save(note);
		return renderResult(Global.TRUE, text("保存日志成功！"));
	}
	
	/**
	 * 删除日志
	 */
	@RequiresPermissions("note:note:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Note note) {
		noteService.delete(note);
		return renderResult(Global.TRUE, text("删除日志成功！"));
	}
	
}