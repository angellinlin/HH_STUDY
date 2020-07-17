package com.sy.hrsys.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrSysApplication {

    public static void main(String[] args) {
        new HrSys();
        SpringApplication.run(HrSysApplication.class, args);
    }

}
