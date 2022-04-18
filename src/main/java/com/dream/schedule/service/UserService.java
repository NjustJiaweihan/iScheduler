package com.dream.schedule.service;

import com.dream.schedule.cmd.AddCycleCmd;
import com.dream.schedule.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserRepo userRepo;

    public boolean check(String username){
        return ! Objects.isNull(userRepo.get(username));
    }

    public void register(String username, Integer weekSeq, Date startDate){
        Integer userId = userRepo.insert(username);
        scheduleService.init(userId, weekSeq, startDate);
    }
}
