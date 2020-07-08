package com.javacode2018.lesson001.other;

import com.javacode2018.lesson001.demo5.IocUtils;
import lombok.ToString;
import org.junit.Test;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Method;

public class ReplaceMethodTest {
    public static class MyValueCalculator {

        public String computeValue(String input) {
            return "";
        }

        public String computeValue(String input, int a) {
            return "";
        }

    }

    public static class ReplacementComputeValue implements MethodReplacer {

        public Object reimplement(Object o, Method m, Object[] args) throws Throwable {
            // get the input value, work with it, and return a computed result
            String input = (String) args[0];
            return input;
        }
    }

    @Test
    public void test1() {
        String beanXml = "classpath:/com/javacode2018/lesson001/other/replaceMethodTest.xml";
        ClassPathXmlApplicationContext context = IocUtils.context(beanXml);
        MyValueCalculator myValueCalculator = context.getBean(MyValueCalculator.class);
        System.out.println(myValueCalculator.computeValue("路人甲Java"));

    }
}
