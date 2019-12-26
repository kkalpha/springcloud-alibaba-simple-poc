package com.tech.microservice.service.consumer.web;

import com.tech.microservice.service.consumer.service.ServiceConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServiceConsumerController {

    private final Logger logger = LoggerFactory.getLogger(ServiceConsumerController.class);

    @Autowired
    ServiceConsumerService serviceConsumerService;

    @GetMapping(value = "/service1")
    public String service1() throws Exception {
        logger.info("/service1");
        return serviceConsumerService.service1();
    }

    @GetMapping(value = "/testLoadBalancerClient")
    public String testLoadBalancerClient() throws Exception {
        logger.info("/testLoadBalancerClient");
        return serviceConsumerService.testLoadBalancerClient();
    }


}
