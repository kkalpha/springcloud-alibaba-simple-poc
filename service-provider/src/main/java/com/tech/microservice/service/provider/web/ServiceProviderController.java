package com.tech.microservice.service.provider.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ServiceProviderController {

    private final Logger logger = LoggerFactory.getLogger(ServiceProviderController.class);
    @Value("${server.port}")
    private String port;
    @GetMapping(value = "/service1")
    public String service1() throws Exception {
        logger.info("/service1");
        return "service by service provider: " + port;
    }
    @GetMapping(value = "/badservice")
    public String badservice() throws Exception {
        logger.info("/badservice");
        // 测试超时触发断路器
        int sleepTime = new Random().nextInt(3000);
        logger.info("sleepTime:" + sleepTime);
        Thread.sleep(sleepTime);
        return "service (bad service) by service provider " + port;
    }
}
