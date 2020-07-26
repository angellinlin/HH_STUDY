package com.sy.hrsys3;

import net.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hrsys3Application {

    public static void main(String[] args) {
        SpringApplication.run(Hrsys3Application.class, args);
        new Server();
    }

}
