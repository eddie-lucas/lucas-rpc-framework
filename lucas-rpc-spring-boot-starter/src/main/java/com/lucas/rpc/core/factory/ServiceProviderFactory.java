package com.lucas.rpc.core.factory;

import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.provider.ServiceProvider;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-02 12:15
 **/
public interface ServiceProviderFactory {
    ServiceProvider getInstance(LucasRpcUserConfig lucasRpcUserConfig);
}
