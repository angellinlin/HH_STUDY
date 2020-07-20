package com.sy;

import com.sy.driver.HrSys1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hrsys1Application {

    public static void main(String[] args) {
        new HrSys1();
        SpringApplication.run(Hrsys1Application.class, args);
    }

}
