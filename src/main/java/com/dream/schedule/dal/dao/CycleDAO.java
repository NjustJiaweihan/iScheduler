package com.dream.schedule.dal.dao;

import com.dream.schedule.dal.po.Cycle;
import com.dream.schedule.dal.po.CycleExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * CycleDAO继承基类
 */
@Mapper
@Repository
public interface CycleDAO extends MyBatisBaseDAO<Cycle, Integer, CycleExample> {
}