package com.magicmirror.service;

import com.magicmirror.entity.Note;

import java.util.List;

public interface NoteService {

    List<Note> findList(Note entity);

    void insert(Note entity);

    void delete(int id);
}
