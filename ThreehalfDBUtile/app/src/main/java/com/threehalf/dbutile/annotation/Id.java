package com.threehalf.dbutile.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/19 17:59
 */

@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.FIELD })
public @interface Id {
}
