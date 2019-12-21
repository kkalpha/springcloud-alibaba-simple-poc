package com.tech.microservice.service.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

}

//test:  http://路由网关IP:路由网关Port/服务名/**
//http://localhost:7891/api/service-provider/service1?toke=ok
//http://localhost:7891/api/sentinel-consumer/service1?toke=ok

/*
spring.cloud.gateway.routes[0].uri=lb://service-provider
spring.cloud.gateway.routes[0].predicates[0]=Path=/api
spring.cloud.gateway.routes[0].predicates[1]=Method=GET,POST
spring.cloud.gateway.routes[0].filters[0]=StripPrefix=1

当访问 http://localhost:7891/api/service-provider/service1 的时候
gateway 转到service-provider对应的服务，比如 http://localhost:6802并去掉api
请求则为 http://localhost:6802/service1
*/
