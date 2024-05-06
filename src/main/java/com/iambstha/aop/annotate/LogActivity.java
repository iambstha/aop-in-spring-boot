package com.iambstha.aop.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogActivity {

    Class<?> entity() default Object.class;
    Class<?> repository() default  Object.class;
    String remark() default  "";
    String activity() default "";

}
