package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class DeptHystrixFallbackService implements DeptHystrixService{
    @Override
    public String deptInfo_Ok(Integer id) {
        return "解耦回退方法触发";
    }

    @Override
    public String deptInfo_Timeout(Integer id) {
        return "解耦回退方法触发";
    }
}
