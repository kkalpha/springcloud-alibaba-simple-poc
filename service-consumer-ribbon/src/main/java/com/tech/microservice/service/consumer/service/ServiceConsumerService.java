package com.tech.microservice.service.consumer.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceConsumerService {
    private final Logger logger = LoggerFactory.getLogger(ServiceConsumerService.class);
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public String service1() throws Exception {
        logger.info("/service1");

        StringBuilder result = new StringBuilder();
        result.append(restTemplate.getForEntity("http://service-provider/service1", String.class).getBody());

        return result.toString();
    }

    public String testLoadBalancerClient() throws Exception {
        logger.info("/LoadBalancerClient");

        ServiceInstance serviceInstance = loadBalancerClient.choose("service-provider");
        String path = String.format("http://%s:%s/service1",serviceInstance.getHost(),serviceInstance.getPort());

        return path;
    }
}
