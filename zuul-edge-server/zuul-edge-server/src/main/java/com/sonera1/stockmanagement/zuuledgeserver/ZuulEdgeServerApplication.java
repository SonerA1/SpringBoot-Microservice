package com.sonera1.stockmanagement.zuuledgeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulServer
@EnableZuulProxy
@CrossOrigin(origins = "*",maxAge = 3600)
public class ZuulEdgeServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulEdgeServerApplication.class, args);
    }

}
