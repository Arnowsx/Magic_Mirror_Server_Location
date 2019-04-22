/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.device.web;

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
import com.jeesite.modules.device.entity.DeviceType;
import com.jeesite.modules.device.service.DeviceTypeService;

/**
 * 设备类型Controller
 * @author arnowsx
 * @version 2019-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/device/deviceType")
public class DeviceTypeController extends BaseController {

	@Autowired
	private DeviceTypeService deviceTypeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DeviceType get(Long typeId, boolean isNewRecord) {
		return deviceTypeService.get(String.valueOf(typeId), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("device:deviceType:view")
	@RequestMapping(value = {"list", ""})
	public String list(DeviceType deviceType, Model model) {
		model.addAttribute("deviceType", deviceType);
		return "modules/device/deviceTypeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("device:deviceType:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DeviceType> listData(DeviceType deviceType, HttpServletRequest request, HttpServletResponse response) {
		deviceType.setPage(new Page<>(request, response));
		Page<DeviceType> page = deviceTypeService.findPage(deviceType);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("device:deviceType:view")
	@RequestMapping(value = "form")
	public String form(DeviceType deviceType, Model model) {
		model.addAttribute("deviceType", deviceType);
		return "modules/device/deviceTypeForm";
	}

	/**
	 * 保存设备类型
	 */
	@RequiresPermissions("device:deviceType:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DeviceType deviceType) {
		deviceTypeService.save(deviceType);
		return renderResult(Global.TRUE, text("保存设备类型成功！"));
	}
	
	/**
	 * 删除设备类型
	 */
	@RequiresPermissions("device:deviceType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DeviceType deviceType) {
		deviceTypeService.delete(deviceType);
		return renderResult(Global.TRUE, text("删除设备类型成功！"));
	}
	
}