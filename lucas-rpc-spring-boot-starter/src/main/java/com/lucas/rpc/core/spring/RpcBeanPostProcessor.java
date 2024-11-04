package com.lucas.rpc.core.spring;

import com.lucas.rpc.core.annotation.Rpc;
import com.lucas.rpc.core.annotation.RpcMethod;
import com.lucas.rpc.core.annotation.RpcProvider;
import com.lucas.rpc.core.provider.ServiceProvider;
import com.lucas.rpc.core.detail.RpcServiceDetail;
import com.lucas.rpc.core.utils.ApplicationContextUtil;
import com.lucas.rpc.core.utils.RpcServiceDetailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-01 20:18
 **/
@Slf4j
@Component
public class RpcBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(RpcProvider.class)) {
            log.info("[{}] 携带了注解[@{}]", clazz.getName(), RpcProvider.class.getSimpleName());
            RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
            String[] value = requestMapping.value();
            Method[] declaredMethods = clazz.getDeclaredMethods();
            RpcServiceDetail rpcServiceDetail = null;
            for (Method method : declaredMethods) {

                if (method.isAnnotationPresent(GetMapping.class)) {
                    GetMapping getMapping = method.getAnnotation(GetMapping.class);
                    String[] path = getMapping.value();
                    rpcServiceDetail = RpcServiceDetail.builder()
                            .requestMethod("GET")
                            .url(value[0] + path[0])
                            .rpcServiceProvider(bean).build();
                } else {
                    //post
                    PostMapping postMapping = method.getAnnotation(PostMapping.class);
                    String[] path = postMapping.value();
                    rpcServiceDetail = RpcServiceDetail.builder()
                            .requestMethod("POST")
                            .url(value[0] + path[0])
                            .rpcServiceProvider(bean).build();
                }
                RpcServiceDetailUtil.addRpcDetail(rpcServiceDetail);

            }
        }
        return bean;
    }
}
