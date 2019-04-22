/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clock.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.clock.entity.Clock;

/**
 * 闹钟DAO接口
 * @author arnowsx
 * @version 2019-04-21
 */
@MyBatisDao
public interface ClockDao extends CrudDao<Clock> {
	void insertClock(Clock entity);

	void deleteClock(long id);
}