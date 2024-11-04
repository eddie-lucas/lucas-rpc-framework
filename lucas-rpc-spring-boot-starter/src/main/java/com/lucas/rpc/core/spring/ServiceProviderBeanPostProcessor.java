package com.lucas.rpc.core.spring;

import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.detail.RpcServiceDetail;
import com.lucas.rpc.core.provider.ServiceProvider;
import com.lucas.rpc.core.strategy.ServiceProviderStrategy;
import com.lucas.rpc.core.utils.ApplicationContextUtil;
import com.lucas.rpc.core.utils.RpcServiceDetailUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Set;


/**
*@author: LiuCheng
*@description: 
*@date: 2024-11-02 15:18
**/
@Slf4j
@Component
public class ServiceProviderBeanPostProcessor implements BeanPostProcessor , ApplicationContextAware {




    private ConfigurableApplicationContext applicationContext;


    //解析用户的配置，然后注册serviceProvider
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if(clazz.isAnnotationPresent(ConfigurationProperties.class)){
            ConfigurationProperties configurationProperties = clazz.getAnnotation(ConfigurationProperties.class);
            //自定义的配置在application.yml中由lucas-rpc开头
            if(configurationProperties.prefix().equals("lucas-rpc")){
                LucasRpcUserConfig lucasRpcUserConfig = (LucasRpcUserConfig)bean;
                log.info("注册中心类型: {},注册中心地址: {}",lucasRpcUserConfig.getRegisterCenterType(),lucasRpcUserConfig.getRegisterCenterAddress());
                DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)applicationContext.getBeanFactory();
                //策略模式+工厂模式
                ServiceProvider serviceProvider = ServiceProviderStrategy.match(lucasRpcUserConfig).getInstance(lucasRpcUserConfig);
                beanFactory.registerSingleton("serviceProvider",serviceProvider);
                //注册netTransmission
//                NetTransmission netTransmission = NetTransmissionStrategy.match(lucasRpcUserConfig);
//                beanFactory.registerSingleton("netTransmission",netTransmission);

                //注册服务
                Set<RpcServiceDetail> rpcDetaiSet = RpcServiceDetailUtil.getRpcDetaiSet();
                for (RpcServiceDetail rpcServiceDetail : rpcDetaiSet) {
                    rpcServiceDetail.setServerNo(lucasRpcUserConfig.getServerNo());
                    serviceProvider.registerService(rpcServiceDetail);
                }
            }
        }
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (ConfigurableApplicationContext) applicationContext;
        ApplicationContextUtil.setApplicationContext(this.applicationContext);
    }
}
