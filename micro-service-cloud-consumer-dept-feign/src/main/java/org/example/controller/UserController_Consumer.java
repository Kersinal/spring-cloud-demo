package org.example.controller;

import org.example.service.DeptFeignService;
import org.example.service.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController_Consumer {
    @Autowired
    private UserFeignService userFeignService;

    @RequestMapping("/login")
    public String login(String username,String password) {
        return userFeignService.login(username,password);
    }
}
