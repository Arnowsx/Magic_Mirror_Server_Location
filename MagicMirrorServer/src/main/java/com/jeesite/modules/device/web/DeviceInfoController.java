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
import com.jeesite.modules.device.entity.DeviceInfo;
import com.jeesite.modules.device.service.DeviceInfoService;

/**
 * 设备Controller
 * @author arnowsx
 * @version 2019-04-21
 */
@Controller
@RequestMapping(value = "${adminPath}/device/deviceInfo")
public class DeviceInfoController extends BaseController {

	@Autowired
	private DeviceInfoService deviceInfoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public DeviceInfo get(Long deviceId, boolean isNewRecord) {
		return deviceInfoService.get(String.valueOf(deviceId), isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("device:deviceInfo:view")
	@RequestMapping(value = {"list", ""})
	public String list(DeviceInfo deviceInfo, Model model) {
		model.addAttribute("deviceInfo", deviceInfo);
		return "modules/device/deviceInfoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("device:deviceInfo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<DeviceInfo> listData(DeviceInfo deviceInfo, HttpServletRequest request, HttpServletResponse response) {
		deviceInfo.setPage(new Page<>(request, response));
		Page<DeviceInfo> page = deviceInfoService.findPage(deviceInfo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("device:deviceInfo:view")
	@RequestMapping(value = "form")
	public String form(DeviceInfo deviceInfo, Model model) {
		model.addAttribute("deviceInfo", deviceInfo);
		return "modules/device/deviceInfoForm";
	}

	/**
	 * 保存设备
	 */
	@RequiresPermissions("device:deviceInfo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated DeviceInfo deviceInfo) {
		deviceInfoService.save(deviceInfo);
		return renderResult(Global.TRUE, text("保存设备成功！"));
	}
	
	/**
	 * 删除设备
	 */
	@RequiresPermissions("device:deviceInfo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(DeviceInfo deviceInfo) {
		deviceInfoService.delete(deviceInfo);
		return renderResult(Global.TRUE, text("删除设备成功！"));
	}
	
}