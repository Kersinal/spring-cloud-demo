package org.example.controller;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${config.version:123}")
    private String version;

    @RequestMapping("/login")
    public String login(String username,String password) {
        if(password.equals(userService.getUser(username).getPassword()))
            return "success/n" + version;
        else return "failed";
    }
}
