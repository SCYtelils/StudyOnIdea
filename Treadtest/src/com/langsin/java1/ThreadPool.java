package com.langsin.java1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程的方式4：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize: 核心池的大小
 *      maximumPoolSize: 最大线程数
 *      keepAliveTime: 线程没有任务时最多保持多长时间会终止
 *
 * 面试题：创建多线程有几种方式？四种
 * 1.创建Thread子类
 * 2.继承Runnable接口
 * 3.继承Callable接口
 * 4.使用线程池
 *
 * Executors.newCachedThreadPool();  创建一个可根据需要创建新线程的线性池
 * Executors.newFixedThreadPool();  创建一个可重用固定线程数的线程池
 * Executors.newSingleThreadExecutor();   创建只有一个线程的线程池
 * Executors.newScheduledThreadPool(n);   创建一个线程池，它可安排在给定延迟后运行命令或者定期的执行
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/7 16:47
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <=100; i++) {
            if (i %2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适合使用于Runnable
//        service.submit();//适合使用于Callable
        //关闭线程池
        service.shutdown();
    }
}
