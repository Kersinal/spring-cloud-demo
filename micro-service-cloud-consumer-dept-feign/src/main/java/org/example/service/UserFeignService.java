package org.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "microservicecloudprovideruser")
public interface UserFeignService {

    @RequestMapping("/login")
    public String login(String username, String password);
}
