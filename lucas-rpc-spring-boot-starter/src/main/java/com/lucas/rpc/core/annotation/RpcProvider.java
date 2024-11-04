package com.lucas.rpc.core.annotation;

import java.lang.annotation.*;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-01 18:22
 **/
@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RpcProvider {
    String group() default "";
    String version() default "";
}
