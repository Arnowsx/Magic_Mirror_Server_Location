package com.magicmirror.service.serviceImp;

import com.magicmirror.dao.ClockDao;
import com.magicmirror.entity.Clock;
import com.magicmirror.service.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClockServiceImpl implements ClockService {

    @Autowired
    private ClockDao dao;

    @Override
    public List<Clock> findList(Clock clock) {
        return dao.findList(clock);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void insert(Clock clock) {
        dao.insert(clock);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void update(Clock clock) {
        dao.updateByPrimaryKey(clock);
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public void delete(int id) {
        dao.delete(id);
    }
}
