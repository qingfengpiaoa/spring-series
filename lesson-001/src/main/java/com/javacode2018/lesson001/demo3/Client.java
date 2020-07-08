package com.javacode2018.lesson001.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.Unsafe;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class Client {

    public static void main(String[] args) {

        //1.bean配置文件位置
        String beanXml = "classpath:/com/javacode2018/lesson001/demo3/beans.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println("spring容器中所有bean如下：");

        //getBeanDefinitionNames用于获取容器中所有bean的名称
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }

        System.out.println("--------------------------");
        //多次获取createByFactoryBean看看是否是同一个对象
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));
        System.out.println("createByFactoryBean:" + context.getBean("createByFactoryBean"));



        IntFunction<IntUnaryOperator> curriedAdd = a -> b  -> a + b;
        System.out.println(curriedAdd.apply(1).applyAsInt(12));


        IntFunction<IntUnaryOperator> curriedAdd1 = new IntFunction<IntUnaryOperator>() {
            @Override
            public IntUnaryOperator apply(final int value) {
                IntUnaryOperator op = new IntUnaryOperator() {
                    @Override
                    public int applyAsInt(int operand) {
                        return operand + value;
                    }
                };
                return op;
            }
        };
        System.out.println(curriedAdd1.apply(1).applyAsInt(12));

    }
}
