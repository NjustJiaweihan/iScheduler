package com.dream.schedule.cmd;

import java.util.Date;
import java.util.List;

public class AddTaskCmd {

    private Integer cycleId;

    private String taskName;

    private List<Date> useDay;

    public Integer getCycleId() {
        return cycleId;
    }

    public void setCycleId(Integer cycleId) {
        this.cycleId = cycleId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<Date> getUseDay() {
        return useDay;
    }

    public void setUseDay(List<Date> useDay) {
        this.useDay = useDay;
    }
}
