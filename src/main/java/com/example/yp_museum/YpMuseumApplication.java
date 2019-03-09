package com.example.yp_museum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class YpMuseumApplication {

    public static void main(String[] args) {
        SpringApplication.run(YpMuseumApplication.class, args);
    }

}

