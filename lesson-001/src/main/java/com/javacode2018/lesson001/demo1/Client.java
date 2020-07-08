package com.javacode2018.lesson001.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 公众号：路人甲Java，工作10年的前阿里P7分享Java、算法、数据库方面的技术干货！坚信用技术改变命运，让家人过上更体面的生活!
 */
public class Client {


    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:/com/javacode2018/lesson001/demo1/beans.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        //3.从容器中获取需要的bean
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);

        //4.使用对象
        helloWorld.say();


        MyData myData = new MyData();
//        new Thread(()->{
//            try {
//                Thread.sleep(10);
//            } catch (Exception ex) {}
//            myData.addTO60();
//        },"ThreadA").start();
//
//        while (myData.number ==0) {
////            System.out.println("当前值为"+myData.number);
//        }
//        System.out.println("当前值为"+myData.number);



        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlus();
                }
//                System.out.println(Thread.currentThread().getName());
            },String.valueOf(i)).start();
        }
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {}
        System.out.println(myData.number);
    }
}

class MyData {
    volatile int number = 0;
    public void addTO60() {
        number = 60;
    }

    public void addPlus() {
        number++;
    }
}

