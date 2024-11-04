package com.lucs.rpc.example;

import com.lucas.rpc.core.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-01 19:17
 **/
@EnableRpc
@SpringBootApplication
public class ExampleServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleServerApplication.class, args);
    }
}
