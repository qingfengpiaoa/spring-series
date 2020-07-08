package com.javacode2018.lesson001.demo23;


import lombok.val;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

interface Demo1T1 {

}

interface Demo1T2 {

}
public class Demo1<T1,T2 extends Integer,T3 extends Demo1T1 & Demo1T2> {

    public static void main(String[] args) {
        TypeVariable<Class<Demo1>>[] typeParameters = Demo1.class.getTypeParameters();//@4
        for (TypeVariable<Class<Demo1>> typeParameter : typeParameters) {
            System.out.println("变量名称:" + typeParameter.getName());
            System.out.println("这个变量在哪声明的:" + typeParameter.getGenericDeclaration());
            Type[] bounds = typeParameter.getBounds();
            System.out.println("这个变量上边界数量:" + bounds.length);
            System.out.println("这个变量上边界清单:");
            for (Type bound : bounds) {
                System.out.println(bound.getTypeName());
            }
            System.out.println("--------------------");
        }

        AnnotationConfigApplicationContext annotationConfigApplicationContext = null;
        ClassPathXmlApplicationContext cla = null;
    }
}
