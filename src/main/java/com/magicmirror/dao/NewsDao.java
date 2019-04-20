package com.magicmirror.dao;

import com.magicmirror.entity.News;

public interface NewsDao {
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
}