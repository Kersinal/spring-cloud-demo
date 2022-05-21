package org.example.controller;

import com.netflix.loadbalancer.IRule;
import org.example.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    private static final String REST_URL_PROVIDER_PREFIX = "http://microservicecloudproviderdept";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/get/" + id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> getAll() {
        return restTemplate.getForObject(REST_URL_PROVIDER_PREFIX + "/dept/list", List.class);
    }
}
