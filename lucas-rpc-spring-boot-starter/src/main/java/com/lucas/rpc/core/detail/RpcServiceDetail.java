package com.lucas.rpc.core.detail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: LiuCheng
 * @description: 记录rpc服务的细节
 * @date: 2024-11-02 09:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RpcServiceDetail {
    private String serverNo;
    private Object rpcServiceProvider;
    private String requestMethod;
    private String url;

    public String getRpcServiceName(){
        return this.getUrl()+"#"+this.getRequestMethod()+"#"+this.serverNo;
    }

}
