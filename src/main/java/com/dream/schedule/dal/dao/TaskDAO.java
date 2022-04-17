package com.dream.schedule.dal.dao;

import com.dream.schedule.dal.po.Task;
import com.dream.schedule.dal.po.TaskExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * TaskDAO继承基类
 */
@Mapper
@Repository
public interface TaskDAO extends MyBatisBaseDAO<Task, Integer, TaskExample> {
}