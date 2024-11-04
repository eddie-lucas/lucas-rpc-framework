package com.lucas.rpc.core.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: LiuCheng
 * @description: 用于读取用户的配置
 * @date: 2024-11-02 09:57
 **/



@Component
@ConfigurationProperties(prefix = "lucas-rpc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LucasRpcUserConfig {
    private String serverNo;
    private String registerCenterType = "nacos";
    private String registerCenterAddress;
    private String ioType = "bio";
}
