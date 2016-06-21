package com.threehalf.dbutile.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jayqiu
 * @describe
 * @date 2016/5/19 18:00
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { java.lang.annotation.ElementType.TYPE })
public @interface Table {
    /**
     * 表名
     *
     * @return
     */
    public abstract String tabName();
}
