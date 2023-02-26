package com.code.gmall.common.cache;

import java.lang.annotation.*;

/**
 * @ClassName GmallCache
 * @Description
 * @Author violet2233
 * @Date 2023/2/26 16:47
 * @Version v1.0
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface GmallCache {
    //  定义一个数据 sku:skuId
    //  目的用这个前缀要想组成 缓存的key！
    String prefix() default "cache:";

}
