package com.lucs.rpc.example.controller;

import com.lucas.rpc.core.annotation.RpcMethod;
import com.lucas.rpc.core.annotation.RpcProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: LiuCheng
 * @description:
 * @date: 2024-11-04 17:56
 **/
@Controller
@RequestMapping("/hello")
@RpcProvider
public class RemoteController {

    @GetMapping("/get")
    @ResponseBody
    public Object get(){
        System.out.println("hello  --");
        return "hello,rpc";
    }
}
