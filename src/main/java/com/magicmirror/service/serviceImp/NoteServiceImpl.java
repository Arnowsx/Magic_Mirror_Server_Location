package com.magicmirror.service.serviceImp;

import com.magicmirror.dao.NoteDao;
import com.magicmirror.entity.Note;
import com.magicmirror.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao dao;

    @Override
    public List<Note> findList(Note entity) {
        return dao.findList(entity);
    }

    @Override
    public void insert(Note entity) {
        dao.insert(entity);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }
}
