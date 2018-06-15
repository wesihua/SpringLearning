package com.wei.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自己看源码或者参考网址：https://www.cnblogs.com/peida/archive/2013/04/24/3036689.html
 * @author weisihua
 * @date 2017年12月11日
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Inherited
@Target(ElementType.ANNOTATION_TYPE)
public @interface CustomType {

}
