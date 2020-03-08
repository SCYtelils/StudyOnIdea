package com.langsin.java;

import jdk.nashorn.internal.runtime.NumberToString;

import java.util.concurrent.*;

/**
 * 创建多线程的方法四：
 *      创建线程池
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/7 18:41
 */

//线程类
class NumCount implements Runnable {

    //重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
//主类
public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumCount());//用于Runnable
//        service.submit();//用于Callable
        //关闭线程池
        service.shutdown();
    }
}
