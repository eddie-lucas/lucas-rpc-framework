//package com.lucas.rpc.core.net;
//
//import com.sun.org.apache.xpath.internal.axes.SubContextList;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.xml.ws.Response;
//import java.io.Serializable;
//
///**
// * @author: LiuCheng
// * @description: R类
// * @date: 2024-11-04 16:31
// **/
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class RpcResponse <T> implements Serializable {
//    private static final long serialVersionUID = -3463729282217655571L;
//
//    private String requestId;
//    private Integer code;
//    private String message;
//    private T data;
//
//    public static <T> RpcResponse <T> success(String requestId,T data){
//        RpcResponse<T> response = new RpcResponse();
//        response.setRequestId(requestId);
//        response.setCode(200);
//        response.setMessage("成功");
//        if(data!=null) response.setData(data);
//        return response;
//    }
//
//    public static <T> RpcResponse <T> fail(String requestId){
//        RpcResponse<T> response = new RpcResponse();
//        response.setRequestId(requestId);
//        response.setCode(500);
//        response.setMessage("失败");
//        return response;
//    }
//}
