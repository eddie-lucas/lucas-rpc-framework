package com.lucas.rpc.core.utils;

import com.lucas.rpc.core.detail.RpcServiceDetail;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-04 18:12
 **/
public class RpcServiceDetailUtil {
    private static Set<RpcServiceDetail> rpcDetaiSet = new HashSet<>();
    public static void addRpcDetail(RpcServiceDetail rpcServiceDetail){
        rpcDetaiSet.add(rpcServiceDetail);
    }

    public static Set<RpcServiceDetail> getRpcDetaiSet(){
        return rpcDetaiSet;
    }
}
