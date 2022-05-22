package org.example.controller;

import org.example.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController_Consumer {
    @Autowired
    private DeptFeignService deptFeignService;

    @ResponseBody
    @RequestMapping("/test")
    public String test() {
        return deptFeignService.test();
    }
}
