package com.abt.jdbc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        List<ServiceInstance> serviceInstances = client.getInstances("hello-service");
        serviceInstances.forEach(instance -> System.out.println(("/hello, host:" + instance.getHost()
                + ", service id:" + instance.getServiceId())));
        return "Hello,World";
    }
}
