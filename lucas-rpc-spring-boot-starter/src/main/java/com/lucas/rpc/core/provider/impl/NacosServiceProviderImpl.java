package com.lucas.rpc.core.provider.impl;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.lucas.rpc.core.config.LucasRpcUserConfig;
import com.lucas.rpc.core.provider.ServiceProvider;
import com.lucas.rpc.core.detail.RpcServiceDetail;
import com.lucas.rpc.core.utils.ApplicationContextUtil;
import lombok.SneakyThrows;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-02 09:43
 **/
public class NacosServiceProviderImpl implements ServiceProvider {

    private String registerCenterAddress;

    public NacosServiceProviderImpl(LucasRpcUserConfig lucasRpcUserConfig){
        this.registerCenterAddress = lucasRpcUserConfig.getRegisterCenterAddress();
    }

    @SneakyThrows
    @Override
    public void registerService(RpcServiceDetail rpcServiceDetail) {
        //获取到nacos注册中心
        NamingService namingService = NacosFactory.createNamingService(registerCenterAddress);
        String ip = InetAddress.getLocalHost().getHostAddress();
        //开发到这里的时候，发现需要获取端口，但是又需要ApplicationContext，所以就将它放在工具类中，方便随时获取
        int port = Integer.parseInt(ApplicationContextUtil.getApplicationContext().getBean(Environment.class).getProperty("server.port"));
        //原来的RpcServiceDetail只有3个属性，开发到这里发现需要一个serviceName
        namingService.registerInstance(rpcServiceDetail.getRpcServiceName(), ip,port);

    }

    @SneakyThrows
    @Override
    public InetSocketAddress selectServiceInetSocketAddress(String serviceName){
        //获取到nacos注册中心
        NamingService namingService = NacosFactory.createNamingService(registerCenterAddress);
        Instance instance = namingService.selectOneHealthyInstance(serviceName);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(instance.getIp(),instance.getPort());
        return inetSocketAddress;
    }
}
