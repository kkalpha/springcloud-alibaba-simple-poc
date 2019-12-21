package com.tech.microservice.service.sentinel.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name= "service-provider",fallback = ServiceSentinelServiceFallback.class)
public interface ServiceSentinelService {

    @RequestMapping("/service1")
    String service1();

    @RequestMapping(value = "/badservice", method = RequestMethod.GET)
    String badservice() ;

}
