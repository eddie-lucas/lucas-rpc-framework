//package com.lucas.rpc.core.strategy;
//
//import com.lucas.rpc.core.config.LucasRpcUserConfig;
//import com.lucas.rpc.core.factory.NacosServiceProviderFactory;
//import com.lucas.rpc.core.factory.ServiceProviderFactory;
//import com.lucas.rpc.core.net.NetTransmission;
//import com.lucas.rpc.core.net.impl.BIONetTransmission;
//import com.lucas.rpc.core.net.impl.NIONetTransmission;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author: LiuCheng
// * @description:
// * @date: 2024-11-03 13:24
// **/
//public class NetTransmissionStrategy {
//    private static Map<String, NetTransmission> map;
//    static {
//        map = new HashMap<>();
//        map.put("bio",new BIONetTransmission());
//        map.put("nio",new NIONetTransmission());
//    }
//    public static NetTransmission match(LucasRpcUserConfig lucasRpcUserConfig){
//        return map.get(lucasRpcUserConfig.getIoType());
//    }
//}
