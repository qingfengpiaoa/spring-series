package com.javacode2018.lesson001.demo19;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CompontentScanTest {
    @Test
    public void test1() {
        String configLocation = "com/javacode2018/lesson001/demo19/beans1.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s + "->" + context.getBean(s));
        }
    }
}
