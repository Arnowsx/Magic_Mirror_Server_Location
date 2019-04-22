package com.magicmirror.controller;

import com.alibaba.fastjson.JSONObject;
import com.magicmirror.entity.DeviceInfo;
import com.magicmirror.service.DeviceInfoSevice;
import com.magicmirror.utils.ServerReponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/di")
public class DeviceInfoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DeviceInfoSevice deviceInfoSevice;

    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public String findList(DeviceInfo entity){
        List<DeviceInfo> list = deviceInfoSevice.findList(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess(list, list.size()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(DeviceInfo entity){
        deviceInfoSevice.insert(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("添加成功"));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(DeviceInfo entity){
        deviceInfoSevice.update(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("修改成功"));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(int id){
        deviceInfoSevice.delete(id);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("删除成功"));
    }

    @RequestMapping(value = "/isOnline", method = RequestMethod.GET)
    public String isOnline(int id){
        boolean res = deviceInfoSevice.isOnline(id);
        return JSONObject.toJSONString(ServerReponse.createBySuccess(res));
    }
}
