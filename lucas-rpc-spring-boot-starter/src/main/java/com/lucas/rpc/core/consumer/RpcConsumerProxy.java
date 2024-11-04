//package com.lucas.rpc.core.consumer;
//
//import com.lucas.rpc.core.detail.RpcServiceDetail;
//import com.lucas.rpc.core.net.NetTransmission;
//import com.lucas.rpc.core.net.RpcRequest;
//import com.lucas.rpc.core.net.RpcResponse;
//import com.lucas.rpc.core.utils.ApplicationContextUtil;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.apache.http.client.methods.RequestBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.Resource;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.util.UUID;
//
///**
// * @author: LiuCheng
// * @description:
// * @date: 2024-11-03 12:34
// **/
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RpcConsumerProxy implements InvocationHandler {
//    private RpcServiceDetail rpcServiceDetail;
//
//    @Override
//    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        //需要通过代理去调用了
//        //先拿到网络传输的对象
//        NetTransmission netTransmission = (NetTransmission) ApplicationContextUtil.getApplicationContext().getBean("netTransmission");
//        RpcRequest rpcRequest = RpcRequest.builder().requestId(UUID.randomUUID().toString())
//                .interfaceName(method.getDeclaringClass().getName())
//                .methodName(method.getName())
//                .params(args)
//                .paramTypes(method.getParameterTypes())
//                .build();
//        RpcResponse<Object> response = netTransmission.sendRequest(rpcRequest);
//        //省略检查操作（流水号是否相等，响应码是否成功等）
//        return response.getData();
//    }
//
//    public <T> T getProxy(Class<T> clazz) {
//        return  (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class<?>[]{clazz},this);
//    }
//}
