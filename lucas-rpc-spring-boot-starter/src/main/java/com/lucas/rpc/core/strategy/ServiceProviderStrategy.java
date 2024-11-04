package com.lucas.rpc.core.strategy;

import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.factory.NacosServiceProviderFactory;
import com.lucas.rpc.core.factory.ServiceProviderFactory;
import com.lucas.rpc.core.provider.impl.NacosServiceProviderImpl;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-02 12:06
 **/
public class ServiceProviderStrategy {
    private static Map<String,ServiceProviderFactory> factoryMap;
    static {
        factoryMap = new HashMap<>();
        factoryMap.put("nacos",new NacosServiceProviderFactory());
        //可以在这里放入zookeeper注册中心
    }
    public static ServiceProviderFactory match(LucasRpcUserConfig lucasRpcUserConfig){
        return factoryMap.get(lucasRpcUserConfig.getRegisterCenterType());
    }
}
