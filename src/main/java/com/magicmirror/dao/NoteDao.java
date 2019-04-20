package com.magicmirror.dao;

import com.magicmirror.entity.Note;

public interface NoteDao {
    int deleteByPrimaryKey(Integer noteId);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer noteId);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}