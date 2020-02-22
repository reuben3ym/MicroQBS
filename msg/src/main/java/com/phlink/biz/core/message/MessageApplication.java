package com.phlink.biz.core.message;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class MessageApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MessageApplication.class)
                .run(args);
    }
}