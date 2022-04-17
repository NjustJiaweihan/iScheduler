package com.dream.schedule.util;
import com.alibaba.fastjson.JSON;
import com.dream.schedule.vo.TaskVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.dream.schedule.dal.po.Cycle;
import com.dream.schedule.dal.po.Task;
import com.dream.schedule.vo.CycleVO;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CycleUtil {

    private CycleUtil(){}

    public static CycleVO convert(Cycle cycle, List<Task> taskList){
        CycleVO cycleVO = new CycleVO();
        cycleVO.setId(cycle.getId());
        cycleVO.setWeekSeq(cycle.getWeekSeq());
        cycleVO.setStartDate(DateUtil.formatDate(cycle.getStartDate()));
        cycleVO.setEndDate(DateUtil.formatDate(cycle.getEndDate()));
        cycleVO.setDayCount(cycle.getDayCount());

        List<TaskVO> taskVOList = new ArrayList<>();
        for (Task task : taskList) {
            TaskVO taskVO = new TaskVO();
            taskVO.setId(task.getId());
            taskVO.setTaskName(task.getTaskName());
            taskVO.setColor(task.getColor());
            taskVO.setUseDayList(JSON.parseArray(task.getUseDay(), Date.class).stream().map(DateUtil::formatDate).collect(Collectors.toList()));
            taskVOList.add(taskVO);
        }
        cycleVO.setTaskList(taskVOList);

        return cycleVO;
    }
}
