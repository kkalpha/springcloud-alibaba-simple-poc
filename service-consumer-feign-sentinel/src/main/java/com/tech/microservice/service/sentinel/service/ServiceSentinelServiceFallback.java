package com.tech.microservice.service.sentinel.service;


import org.springframework.stereotype.Component;

@Component
public class ServiceSentinelServiceFallback implements ServiceSentinelService {
    @Override
    public String service1() {
        return "service1 fallback";
    }

    @Override
    public String badservice() {
        return "badservice fallback";
    }
}
