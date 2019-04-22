package com.magicmirror.controller;

import com.alibaba.fastjson.JSONObject;
import com.magicmirror.entity.DeviceType;
import com.magicmirror.service.DeviceTypeService;
import com.magicmirror.utils.ServerReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/dtype")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeService deviceTypeService;

    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public String findList(DeviceType entity){
        List<DeviceType> list = deviceTypeService.findList(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess(list, list.size()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(DeviceType entity){
        deviceTypeService.insert(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("添加成功"));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(DeviceType entity){
        deviceTypeService.update(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("修改成功"));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(int id){
        deviceTypeService.delete(id);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("删除成功"));
    }

}
