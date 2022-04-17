package com.dream.schedule.vo;

import java.util.Date;
import java.util.List;

public class TaskVO {

    private Integer id;

    private String taskName;

    private Byte color;

    private List<String> useDayList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Byte getColor() {
        return color;
    }

    public void setColor(Byte color) {
        this.color = color;
    }

    public List<String> getUseDayList() {
        return useDayList;
    }

    public void setUseDayList(List<String> useDayList) {
        this.useDayList = useDayList;
    }
}
