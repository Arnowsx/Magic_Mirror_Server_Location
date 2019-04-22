/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.clock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.clock.entity.Clock;
import com.jeesite.modules.clock.dao.ClockDao;

/**
 * 闹钟Service
 * @author arnowsx
 * @version 2019-04-21
 */
@Service
@Transactional(readOnly=true)
public class ClockService extends CrudService<ClockDao, Clock> {
	
	/**
	 * 获取单条数据
	 * @param clock
	 * @return
	 */
	@Override
	public Clock get(Clock clock) {
		return super.get(clock);
	}
	
	/**
	 * 查询分页数据
	 * @param clock 查询条件
	 * @param clock.page 分页对象
	 * @return
	 */
	@Override
	public Page<Clock> findPage(Clock clock) {
		return super.findPage(clock);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param clock
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Clock clock) {
		if(clock.getClockId() == null || clock.getClockId().equals("")){
			dao.insertClock(clock);
		}else {
			super.save(clock);
		}
	}
	
	/**
	 * 更新状态
	 * @param clock
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Clock clock) {
		super.updateStatus(clock);
	}
	
	/**
	 * 删除数据
	 * @param clock
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Clock clock) {
		dao.deleteClock(clock.getClockId());
	}
	
}