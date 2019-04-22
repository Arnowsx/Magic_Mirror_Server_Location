package com.magicmirror.controller;

import com.alibaba.fastjson.JSONObject;
import com.magicmirror.entity.Note;
import com.magicmirror.service.NoteService;
import com.magicmirror.utils.ServerReponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/note")
public class NoteController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "findList", method = RequestMethod.GET)
    public String findList(Note entity){
        List<Note> noteList = noteService.findList(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess(noteList, noteList.size()));
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Note entity){
        noteService.insert(entity);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("添加成功"));
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(int id){
        noteService.delete(id);
        return JSONObject.toJSONString(ServerReponse.createBySuccess("删除成功"));
    }
}
