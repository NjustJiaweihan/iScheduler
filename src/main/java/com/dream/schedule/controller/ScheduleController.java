package com.dream.schedule.controller;

import com.dream.schedule.cmd.AddCycleCmd;
import com.dream.schedule.cmd.AddTaskCmd;
import com.dream.schedule.service.ScheduleService;
import com.dream.schedule.vo.CycleVO;
import com.dream.schedule.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/init")
    public void init(@RequestBody AddCycleCmd cycleCmd){
        scheduleService.init(cycleCmd);
    }

    @GetMapping("/overview")
    public List<CycleVO> overview(){
        return scheduleService.overview();
    }

    @PostMapping("/cycle")
    public void addCycle(){
        scheduleService.addCycle();
    }

    @PostMapping("/task")
    public void addTask(@RequestBody AddTaskCmd cmd){
        scheduleService.addTask(cmd);
    }
}
