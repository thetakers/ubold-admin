package com.ubold.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ningzuokun on 2017/5/15.
 */
@SpringBootApplication
//@EnableOAuth2Sso
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(RabcApplication.class, args);
    }
}
