package com.dream.schedule.repo;

import com.dream.schedule.dal.dao.UserDAO;
import com.dream.schedule.dal.po.User;
import com.dream.schedule.dal.po.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserRepo {

    @Resource
    private UserDAO userDAO;

    public Integer insert(String name){
        User record = new User();
        record.setName(name);
        userDAO.insertSelective(record);
        return record.getId();
    }

    public User get(String name){
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> users = userDAO.selectByExample(example);
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }

    public User get(Integer id){
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(id);
        List<User> users = userDAO.selectByExample(example);
        return CollectionUtils.isEmpty(users) ? null : users.get(0);
    }
}
