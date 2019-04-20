package com.magicmirror.dao;

import com.magicmirror.entity.Contacts;

public interface ContactsDao {
    int deleteByPrimaryKey(Integer contactId);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer contactId);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);
}