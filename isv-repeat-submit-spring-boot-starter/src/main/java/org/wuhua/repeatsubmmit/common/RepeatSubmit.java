package org.wuhua.repeatsubmmit.common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatSubmit {
    boolean enable() default true; // 是否开启幂等性保护
    long timeout() default 30L; // 幂等性保护时长，默认为30秒
}
