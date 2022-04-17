package com.dream.schedule.repo;

import com.dream.schedule.dal.dao.TaskDAO;
import com.dream.schedule.dal.po.Task;
import com.dream.schedule.dal.po.TaskExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepo {

    @Autowired
    private TaskDAO taskDAO;

    public List<Task> getByCycle(Integer cycleId){
        TaskExample example = new TaskExample();
        example.createCriteria().andCycleIdEqualTo(cycleId);
        List<Task> taskList = taskDAO.selectByExample(example);
        return CollectionUtils.isEmpty(taskList) ? new ArrayList<>() : taskList;
    }

    public void insert(Task task){
        taskDAO.insertSelective(task);
    }
}
