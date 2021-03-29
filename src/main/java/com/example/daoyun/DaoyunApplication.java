package com.example.daoyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.daoyun.dao")
@SpringBootApplication
public class DaoyunApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaoyunApplication.class, args);
    }

}
