package com.lucas.rpc.core.annotation;

import java.lang.annotation.*;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-01 18:20
 **/
@Target(ElementType.FIELD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Rpc {
    String group() default "";
    String version() default "";
}
