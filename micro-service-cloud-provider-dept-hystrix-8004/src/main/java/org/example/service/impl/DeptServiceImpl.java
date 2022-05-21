package org.example.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.example.service.DeptService;
import org.springframework.cloud.commons.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("DeptService")
public class DeptServiceImpl implements DeptService {

    @Override
    public String deptInfo_Ok(Integer id) {
        return "线程池" + Thread.currentThread().getName() + " deftInfo_Ok,id: " + id;
    }

    //一旦该方法失败并抛出了异常信息后，会自动调用  @HystrixCommand 注解标注的 fallbackMethod 指定的方法
    @HystrixCommand(fallbackMethod = "dept_TimeoutHandle",
    //规定 5 秒钟以内就不报错，正常运行，超过 5 秒就报错，调用指定的方法
    commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    @Override
    public String deptInfo_Timeout(Integer id) {
        int outTime = 4;
        try {
            TimeUnit.SECONDS.sleep(outTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池" + Thread.currentThread().getName() + " deftInfo_Timeout,id: " + id + "  耗时：" + outTime;
    }

    @Override
    @HystrixCommand(fallbackMethod = "deptCircuitBreaker_fallback",commandProperties = {
            //以下参数在 HystrixCommandProperties 类中有默认配置
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启熔断器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds",value = "2000"), //统计时间窗
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //统计时间窗内请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //在统计时间窗口期以内，请求失败率达到 60% 时进入熔断状态
    })
    public String deptCircuitBreaker(Integer id) {
        if (id < 0) {
            //当传入的 id 为负数时，抛出异常，调用降级方法
            throw new RuntimeException("c语言中文网提醒您，id 不能是负数！");
        }
        String serialNum = IdUtils.getUnresolvedServiceId();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号为：" + serialNum;
    }

    public String dept_TimeoutHandle(Integer id) {
        return "系统繁忙，线程池: " + Thread.currentThread().getName() + "deftInfo_Timeout,id: " + id;
    }

    //deptCircuitBreaker 的降级方法
    public String deptCircuitBreaker_fallback(Integer id) {
        return "c语言中文网提醒您，id 不能是负数,请稍后重试!\t id:" + id;
    }
}
