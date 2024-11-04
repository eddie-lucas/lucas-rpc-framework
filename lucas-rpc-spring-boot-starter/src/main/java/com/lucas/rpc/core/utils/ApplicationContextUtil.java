package com.lucas.rpc.core.utils;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-03 10:56
 **/
@Component
public class ApplicationContextUtil{
    private static ConfigurableApplicationContext applicationContext;

    public static ConfigurableApplicationContext getApplicationContext(){
        return applicationContext;
    }

    public static void  setApplicationContext(ConfigurableApplicationContext ctx){
        applicationContext = ctx;
    }
}
