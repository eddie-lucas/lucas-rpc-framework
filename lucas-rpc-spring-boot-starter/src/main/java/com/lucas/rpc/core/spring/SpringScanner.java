package com.lucas.rpc.core.spring;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * @author: LiuCheng
 * @description: 用来扫描框架内的spring相关的组件
 * @date: 2024-11-01 20:35
 **/
public class SpringScanner extends ClassPathBeanDefinitionScanner {
    public SpringScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> annotation) {
        super(registry);
        super.addIncludeFilter(new AnnotationTypeFilter(annotation));
    }

    public int scan(String... basePackages){
        return super.scan(basePackages);
    }

    public Set<BeanDefinitionHolder> doScan(String... basePackages){
        return super.doScan(basePackages);
    }
}
