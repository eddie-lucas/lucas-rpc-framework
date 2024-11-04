package com.lucas.rpc.core.spring;

import com.alibaba.nacos.shaded.com.google.errorprone.annotations.Var;
import com.lucas.rpc.core.annotation.EnableRpc;
import com.lucas.rpc.core.annotation.Rpc;
import com.lucas.rpc.core.annotation.RpcProvider;
import com.lucas.rpc.core.config.LucasRpcUserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author: LiuCheng
 * @description: 位于启动类的@Import注解会让spring执行到框架内部的该类
 * @date: 2024-11-01 18:28
 **/
@Slf4j
public class EnableRpcRegistrar implements ImportBeanDefinitionRegistrar{

    private static final String RPC_FRAMEWORK_BASE_PACKAGE = "com.lucas.rpc.core";

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {



        //坑点1：如果只是给RpcBeanPostProcessor加上Component注解，然后启动client/server，RpcBeanPostProcessor不会被扫描到
        //因为启动类只扫描其本身所在的包及其子包，对于ExampleClientApplication来说，其只扫描位于com.lucas.example下的所有组件
        //但是框架中的RpcBeanPostProcessor位于com.lucas.rpc.core.spring下，故，不会被扫描到，因此需要自己手动扫描，交由spring管理
        //先扫描rpc框架内部的@Component注解，让其先交由spring管理
        SpringScanner springScanner = new SpringScanner(registry, Component.class);
        int componentCount = springScanner.scan(RPC_FRAMEWORK_BASE_PACKAGE);

        //获取@EnableRpc注解的参数
        AnnotationAttributes enableScanAttrs = AnnotationAttributes
                .fromMap(annotationMetadata.getAnnotationAttributes(EnableRpc.class.getName()));
        //获取包扫描路径
        String[] basePackages = enableScanAttrs.getStringArray("value");
        if(basePackages.length==0){
            //说明就只是简单的@EnableRpc注解，没有任何参数，那么就获取主启动类所在的包名
            basePackages = new String[]{((StandardAnnotationMetadata)annotationMetadata).getIntrospectedClass().getPackage().getName()};
        }
        //扫描提供者的@RpcProvider
        RpcProviderScanner rpcProviderScanner = new RpcProviderScanner(registry, RpcProvider.class);
        int rpcProviderCount = rpcProviderScanner.scan(basePackages);


        log.info("rpcProviderScanner扫描到的@RpcProvider数量是: {}",rpcProviderCount);
        log.info("SpringScanner扫描到的框架内部的@Component数量是: {}",componentCount);

    }
}
