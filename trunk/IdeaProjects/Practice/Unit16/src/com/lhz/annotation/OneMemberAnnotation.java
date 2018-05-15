package com.lhz.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.CONSTRUCTOR)
//用于构造方法

@Retention(RetentionPolicy.RUNTIME)
//在运行时加载Annotation到JVM中

public @interface OneMemberAnnotation {

    //ElementType ELEMENT_TYPE = null;
}
