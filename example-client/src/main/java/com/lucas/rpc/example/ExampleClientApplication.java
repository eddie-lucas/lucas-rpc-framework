package com.lucas.rpc.example;

import com.lucas.rpc.core.annotation.EnableRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-01 16:35
 **/
//使用 @EnableLucasRpc 来开启rpc，主要是进行包扫描，类似于@MapperScan
@EnableRpc
@SpringBootApplication
public class ExampleClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleClientApplication.class, args);
    }
}
