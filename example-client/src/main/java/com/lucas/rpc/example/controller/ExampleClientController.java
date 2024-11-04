package com.lucas.rpc.example.controller;

import com.lucas.rpc.core.annotation.Rpc;
import com.lucas.rpc.core.utils.LucasRpc;
import com.lucas.rpc.example.RemoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-01 16:37
 **/
@Controller
@RequestMapping("/example")
public class ExampleClientController {
    
    //使用@Rpc注解来注入远程服务端服务


    @GetMapping("/remoteCall")
    @ResponseBody
    public String remoteCall(){
        String result = (String) LucasRpc.get("LC666", "/hello/get");
        System.out.println(result);
        return result;
    }
}
