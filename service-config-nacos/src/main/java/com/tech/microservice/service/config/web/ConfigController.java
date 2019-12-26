package com.tech.microservice.service.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yorker
 * @since 12/26/2019 1:39 PM
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${app.config.val1}")
    private String val1;

    @Value("${app.config.val2}")
    private int val2;

    @GetMapping("getConfigVal")
    public String getConfigVal(){
        return "from nacos config: val1 " + val1 + " / val2 " + val2;
    }
}
