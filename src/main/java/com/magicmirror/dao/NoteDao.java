package com.magicmirror.dao;

import com.magicmirror.entity.Note;

import java.util.List;

public interface NoteDao {
    List<Note> findList(Note entity);

    int deleteByPrimaryKey(Integer noteId);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    void delete(int id);
}