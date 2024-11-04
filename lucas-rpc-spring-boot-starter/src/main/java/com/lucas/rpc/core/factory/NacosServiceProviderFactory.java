package com.lucas.rpc.core.factory;

import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.provider.ServiceProvider;
import com.lucas.rpc.core.provider.impl.NacosServiceProviderImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-02 12:10
 **/
public class NacosServiceProviderFactory implements ServiceProviderFactory{
    public ServiceProvider getInstance(LucasRpcUserConfig lucasRpcUserConfig){
        return new NacosServiceProviderImpl(lucasRpcUserConfig);
    }
}
