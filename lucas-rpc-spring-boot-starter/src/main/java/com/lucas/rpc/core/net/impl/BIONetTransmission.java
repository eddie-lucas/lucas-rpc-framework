//package com.lucas.rpc.core.net.impl;
//
//import com.lucas.rpc.core.net.NetTransmission;
//import com.lucas.rpc.core.net.RpcRequest;
//import com.lucas.rpc.core.net.RpcResponse;
//import com.lucas.rpc.core.provider.ServiceProvider;
//import com.lucas.rpc.core.utils.ApplicationContextUtil;
//
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//
///**
// * @author: LiuCheng
// * @description:
// * @date: 2024-11-03 13:27
// **/
//public class BIONetTransmission implements NetTransmission {
//    @Override
//    public RpcResponse<Object> sendRequest(RpcRequest rpcRequest) {
//        ServiceProvider serviceProvider = (ServiceProvider)ApplicationContextUtil.getApplicationContext().getBean("serviceProvider");
//        InetSocketAddress inetSocketAddress = serviceProvider.selectServiceInetSocketAddress(rpcRequest.getInterfaceName());
//        try (Socket socket = new Socket()){
//            //socket+jdk序列化
//            socket.connect(inetSocketAddress);
//            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
//            outputStream.writeObject(rpcRequest);
//            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
//            return (RpcResponse<Object>)inputStream.readObject();
//        }catch (Exception e){
//            throw new RuntimeException("调用失败...",e);
//        }
//    }
//}
