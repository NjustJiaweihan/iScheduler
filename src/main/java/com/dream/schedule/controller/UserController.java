package com.dream.schedule.controller;

import com.dream.schedule.repo.UserRepo;
import com.dream.schedule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/check")
    public boolean isUser(@RequestParam(value = "name") String name){
        return userService.check(name);
    }

    @PostMapping("/register")
    public void register(@RequestParam(value = "name") String name,
                         @RequestParam(value = "weekSeq") Integer weekSeq,
                         @RequestParam(value = "startDate") Date startDate){
        userService.register(name, weekSeq, startDate);
    }
}
