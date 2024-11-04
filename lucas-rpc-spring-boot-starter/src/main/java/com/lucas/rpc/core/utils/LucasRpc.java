package com.lucas.rpc.core.utils;

import com.alibaba.fastjson2.JSON;
import com.lucas.rpc.core.provider.ServiceProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URL;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-04 18:40
 **/
@Slf4j
public class LucasRpc {
    public static Object get(String serverNo,String url){
        ServiceProvider serviceProvider = (ServiceProvider)ApplicationContextUtil.getApplicationContext().getBean("serviceProvider");
        String serviceName = url+"#"+"GET"+"#"+serverNo;
        InetSocketAddress inetSocketAddress = serviceProvider.selectServiceInetSocketAddress(serviceName);
        String ip = inetSocketAddress.getAddress().getHostAddress();
        try {
            URL requestURL = new URL("http://"+ip+":"+inetSocketAddress.getPort()+url);
            HttpURLConnection connection =(HttpURLConnection) requestURL.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = reader.readLine())!=null){
                response.append(line);
            }
            reader.close();
            //偷懒
            return response.toString();
        }catch (Exception e){
            throw new RuntimeException("调用失败",e);
        }
    }
}
