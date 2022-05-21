package org.example.controller;

import org.example.entity.Dept;
import org.example.service.DeptFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController_Consumer {
    @Autowired
    private DeptFeignService deptFeignService;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return deptFeignService.get(id);
    }

    @RequestMapping("/dept/list")
    public List<Dept> getAll(){
        return deptFeignService.list();
    }

    @RequestMapping("/consumer/dept/feign/timeout")
    public String timeOut() {
        return deptFeignService.deptFeignTimeout();
    }

}
