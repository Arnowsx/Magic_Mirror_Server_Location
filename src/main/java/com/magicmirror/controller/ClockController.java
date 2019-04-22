package com.magicmirror.controller;

import com.alibaba.fastjson.JSONObject;
import com.magicmirror.entity.Clock;
import com.magicmirror.service.ClockService;
import com.magicmirror.utils.ServerReponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/clock")
public class ClockController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClockService clockService;

    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public String findList(Clock entity){
        List<Clock> list = clockService.findList(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess(list, list.size()));
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(Clock entity){
        clockService.insert(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("添加成功"));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Clock entity){
        clockService.update(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("修改成功"));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(int id){
        clockService.delete(id);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("删除成功"));
    }
}
