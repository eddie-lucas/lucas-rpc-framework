package com.lucas.rpc.core.provider;

import com.alibaba.nacos.api.naming.pojo.Instance;
import com.lucas.rpc.core.detail.RpcServiceDetail;

import java.net.InetSocketAddress;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-02 09:33
 **/
public interface ServiceProvider {

    void registerService(RpcServiceDetail rpcServiceDetail);

    InetSocketAddress selectServiceInetSocketAddress(String serviceName);
}
