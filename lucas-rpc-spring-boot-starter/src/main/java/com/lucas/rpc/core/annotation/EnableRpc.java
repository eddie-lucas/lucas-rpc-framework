package com.lucas.rpc.core.annotation;

import com.lucas.rpc.core.spring.EnableRpcRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-01 18:21
 **/
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Import(EnableRpcRegistrar.class)
public @interface EnableRpc {

    String[] value() default {};
}
