package com.dream.schedule.dal.dao;

import com.dream.schedule.dal.po.User;
import com.dream.schedule.dal.po.UserExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Mapper
@Repository
public interface UserDAO extends MyBatisBaseDAO<User, Integer, UserExample> {
}