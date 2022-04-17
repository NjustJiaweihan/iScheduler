package com.dream.schedule.repo;

import com.dream.schedule.dal.dao.CycleDAO;
import com.dream.schedule.dal.po.Cycle;
import com.dream.schedule.dal.po.CycleExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class CycleRepo {

    @Autowired
    private CycleDAO cycleDAO;

    public Cycle getLastCycle(Integer userId){
        CycleExample example = new CycleExample();
        example.setOrderByClause("week_seq desc");
        example.setLimit(1);
        example.createCriteria().andUserIdEqualTo(userId);
        List<Cycle> cycleList = cycleDAO.selectByExample(example);
        return CollectionUtils.isEmpty(cycleList) ? null : cycleList.get(0);
    }

    public List<Cycle> getLastFourCycle(Integer userId){
        CycleExample example = new CycleExample();
        example.setOrderByClause("week_seq desc");
        example.setLimit(4);
        example.createCriteria().andUserIdEqualTo(userId);
        List<Cycle> cycleList = cycleDAO.selectByExample(example);
        return CollectionUtils.isEmpty(cycleList) ? null : cycleList;
    }

    public void insert(Cycle cycle){
        cycleDAO.insertSelective(cycle);
    }
}
