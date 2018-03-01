package com.learn.openshift.scale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScalableApp {

    public static void main(String[] args) {
        SpringApplication.run(ScalableApp.class, args);
    }
}
