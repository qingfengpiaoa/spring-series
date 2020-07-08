package com.javacode2018.lesson001.demo18;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Ann2 { //@1
    String name();
}

@Ann2(name = "我是路人甲java") //@2
public class UseAnnotation2 {

}
