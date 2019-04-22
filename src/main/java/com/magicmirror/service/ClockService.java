package com.magicmirror.service;

import com.magicmirror.entity.Clock;

import java.util.List;

public interface ClockService {

    List<Clock> findList(Clock clock);

    void insert(Clock clock);

    void update(Clock clock);

    void delete(int id);
}
