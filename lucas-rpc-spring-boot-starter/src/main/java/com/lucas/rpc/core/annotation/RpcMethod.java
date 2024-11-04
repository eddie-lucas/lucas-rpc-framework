package com.lucas.rpc.core.annotation;

import java.lang.annotation.*;

/**
 * @Author: LiuCheng
 * @Description:
 * @Date: 2024-11-04 17:46
 **/
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Deprecated
public @interface RpcMethod {
}
