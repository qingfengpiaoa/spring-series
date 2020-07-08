package com.javacode2018.lesson001.demo23;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsumer_TraditionDemo {

    public static void main(String[] args) {


    }
}


class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            while (number !=0) {
                //不能生产
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}