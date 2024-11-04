package com.lucas.rpc.core.provider.impl;

import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.provider.ServiceProvider;
import com.lucas.rpc.core.detail.RpcServiceDetail;

import java.net.InetSocketAddress;

/**
 * @author: LiuCheng
 * @description: 未实现的zk注册中心
 * @date: 2024-11-02 15:33
 **/
public class ZookeeperServiceProviderImpl implements ServiceProvider {

    private String registerCenterAddress;

    public ZookeeperServiceProviderImpl(LucasRpcUserConfig lucasRpcUserConfig){
        this.registerCenterAddress = lucasRpcUserConfig.getRegisterCenterAddress();
    }
    @Override
    public void registerService(RpcServiceDetail rpcServiceDetail) {
        //lc TODO
    }

    @Override
    public InetSocketAddress selectServiceInetSocketAddress(String serviceName) {
        return null;
    }
}
