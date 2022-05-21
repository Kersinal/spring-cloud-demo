package org.example.service;

public interface DeptService {

    //hystrix熔断器示例 ok
    public String deptInfo_Ok(Integer id);

    //hystrix熔断器示例 timeout
    public String deptInfo_Timeout(Integer id);

    //hystrix熔断机制
    public String deptCircuitBreaker(Integer id);
}
