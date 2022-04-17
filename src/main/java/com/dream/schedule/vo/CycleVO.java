package com.dream.schedule.vo;

import java.util.Date;
import java.util.List;

public class CycleVO {

    private Integer id;

    private Integer weekSeq;

    private String startDate;

    private String endDate;

    private Integer dayCount;

    private List<TaskVO> taskList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeekSeq() {
        return weekSeq;
    }

    public void setWeekSeq(Integer weekSeq) {
        this.weekSeq = weekSeq;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public List<TaskVO> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<TaskVO> taskList) {
        this.taskList = taskList;
    }
}
