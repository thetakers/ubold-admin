package com.ubold.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Created by ningzuokun on 2017/5/15.
 */
@SpringBootApplication
@EnableResourceServer
public class RabcApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabcApplication.class, args);
    }
}
