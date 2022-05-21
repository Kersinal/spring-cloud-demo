package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.example.service.DeptHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "dept_Global_FallbackMethod")
public class DeptHystrix_Consumer {
    @Autowired
    private DeptHystrixService deptHystrixService;

    @RequestMapping("/consumer/dept/hystrix/ok/{id}")
    public String deptInfo_Ok(@PathVariable("id") Integer id) {
        return deptHystrixService.deptInfo_Ok(id);
    }

    @RequestMapping("/consumer/dept/hystrix/timeout/{id}")
    //@HystrixCommand
    @HystrixCommand(fallbackMethod = "dept_TimeoutHandle")
    public String deptInfo_Timeout(@PathVariable("id") Integer id) {
        String s = deptHystrixService.deptInfo_Timeout(id);
        log.info(s);
        return s;
    }

    public String dept_TimeoutHandle(Integer id) {
        log.info("dept_Timeout 出错，服务已经降级");
        return "系统繁忙 触发回退方法dept_TimeoutHandle";
    }

    public String dept_Global_FallbackMethod() {
        return "系统繁忙，全局回退方法触发";
    }

}
