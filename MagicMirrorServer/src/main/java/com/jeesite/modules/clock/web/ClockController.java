/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clock.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.common.codec.DesUtils;
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
import com.jeesite.modules.clock.entity.Clock;
import com.jeesite.modules.clock.service.ClockService;

/**
 * 闹钟Controller
 * @author arnowsx
 * @version 2019-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/clock/clock")
public class ClockController extends BaseController {

	@Autowired
	private ClockService clockService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Clock get(Long clockId, boolean isNewRecord) {
		return clockService.get(String.valueOf(clockId), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("clock:clock:view")
	@RequestMapping(value = {"list", ""})
	public String list(Clock clock, Model model) {
		String secretKey = Global.getConfig("shiro.loginSubmit.secretKey");

		model.addAttribute("clock", clock);
		return "modules/clock/clockList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("clock:clock:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Clock> listData(Clock clock, HttpServletRequest request, HttpServletResponse response) {
		clock.setPage(new Page<>(request, response));
		Page<Clock> page = clockService.findPage(clock);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("clock:clock:view")
	@RequestMapping(value = "form")
	public String form(Clock clock, Model model) {
		model.addAttribute("clock", clock);
		return "modules/clock/clockForm";
	}

	/**
	 * 保存闹钟
	 */
	@RequiresPermissions("clock:clock:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Clock clock) {
		clockService.save(clock);
		return renderResult(Global.TRUE, text("保存闹钟成功！"));
	}
	
	/**
	 * 删除闹钟
	 */
	@RequiresPermissions("clock:clock:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Clock clock) {
		clockService.delete(clock);
		return renderResult(Global.TRUE, text("删除闹钟成功！"));
	}
	
}