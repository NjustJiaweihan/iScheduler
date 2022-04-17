package com.dream.schedule.controller;

import com.dream.schedule.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/check")
    public boolean isUser(@RequestParam(value = "name") String name){
        return true;
        //return Objects.isNull(userRepo.get(name));
    }

    @GetMapping("/register")
    public void register(@RequestParam(value = "name") String name){

    }
}
