package com.lucas.rpc.core.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

/**
 * @author: LiuCheng
 * @description: 用来扫描框架内的rpc相关的组件
 * @date: 2024-11-01 19:11
 **/
public class RpcProviderScanner extends ClassPathBeanDefinitionScanner {
    public RpcProviderScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> annotation) {
        super(registry);
        super.addIncludeFilter(new AnnotationTypeFilter(annotation));
    }

    public int scan(String... basePackages){
        return super.scan(basePackages);
    }
}
