package org.example.service;

import org.example.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "microservicecloudproviderdept")
public interface DeptFeignService {

    @RequestMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") int id);

    @RequestMapping("/dept/list")
    public List<Dept> list();

    @RequestMapping("/dept/feign/timeout")
    public String deptFeignTimeout();

    @RequestMapping("/test")
    public String test();
}
