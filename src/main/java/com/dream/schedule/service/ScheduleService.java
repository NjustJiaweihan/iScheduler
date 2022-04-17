package com.dream.schedule.service;
import java.util.Date;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.dream.schedule.cmd.AddCycleCmd;
import com.dream.schedule.cmd.AddTaskCmd;
import com.dream.schedule.dal.po.Cycle;
import com.dream.schedule.dal.po.Task;
import com.dream.schedule.repo.CycleRepo;
import com.dream.schedule.repo.TaskRepo;
import com.dream.schedule.util.ColorUtil;
import com.dream.schedule.util.CycleUtil;
import com.dream.schedule.vo.CycleVO;
import com.dream.schedule.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    private final String user = "hanjiawei01";
    private final Integer userId = 1;

    @Autowired
    private CycleRepo cycleRepo;

    @Autowired
    private TaskRepo taskRepo;

    public void init(AddCycleCmd cycleCmd){
        Integer weekSeq = cycleCmd.getWeekSeq();
        Date start = cycleCmd.getStartDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(start);
        for (int i=0; i<4; i++){
            Cycle cycle = new Cycle();
            cycle.setUserId(userId);
            cycle.setWeekSeq(weekSeq);
            cycle.setStartDate(start);
            calendar.add(Calendar.DATE, 13);
            cycle.setEndDate(calendar.getTime());
            cycle.setDayCount(14);
            cycleRepo.insert(cycle);
            weekSeq += 2;
            calendar.add(Calendar.DATE, 1);
            start = calendar.getTime();
        }
    }

    public ScheduleVO overview(){
        List<Cycle> cycleList = cycleRepo.getLastFourCycle(userId);
        ScheduleVO scheduleVO = new ScheduleVO();
        List<CycleVO> cycleVOList = new ArrayList<>();
        for (Cycle cycle : cycleList) {
            CycleVO cycleVO = CycleUtil.convert(cycle, taskRepo.getByCycle(cycle.getId()));
            cycleVOList.add(cycleVO);
        }
        cycleVOList.sort(Comparator.comparing(CycleVO::getWeekSeq));
        scheduleVO.setCycleList(cycleVOList);
        return scheduleVO;
    }

    public void addCycle(){

        Cycle lastCycle = cycleRepo.getLastCycle(userId);
        Calendar calendar = Calendar.getInstance();

        Cycle toAdd = new Cycle();
        toAdd.setUserId(userId);
        toAdd.setWeekSeq(lastCycle.getWeekSeq() + 2);
        calendar.setTime(lastCycle.getEndDate());
        calendar.add(Calendar.DATE, 1);
        toAdd.setStartDate(calendar.getTime());
        calendar.add(Calendar.DATE, 13);
        toAdd.setEndDate(calendar.getTime());
        toAdd.setDayCount(14);

        cycleRepo.insert(toAdd);
    }

    public void addTask(AddTaskCmd cmd){
        Task task = new Task();
        task.setUserId(userId);
        task.setCycleId(cmd.getCycleId());
        task.setTaskName(cmd.getTaskName());
        task.setColor(ColorUtil.getColor());
        task.setUseDay(JSON.toJSONString(cmd.getUseDay()));

        taskRepo.insert(task);
    }
}
