package com.langsin.java1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock对象 ========== jdk5.0新特性
 *
 * 面试题：synchronized 和 Lock 的区别？
 *      相同：都是实现线程同步机制
 *      不同：synchornized机制在执行完相应的同步代码以后，自动释放同步监视器
 *          lock需要手动的启动同步（lock()），同时结束同步也需要手动实现（unlock()）
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/6 17:36
 */

class Windows implements Runnable{

    public static int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {

                //调用锁定的方法
                lock.lock();

                //lock之后的代码相当于同步代码块的效果

                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":正在售卖第" + ticket + "张票");
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //调用解锁的方法
                lock.unlock();
            }

        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Windows windows = new Windows();
        Thread t1 = new Thread(windows);
        Thread t2 = new Thread(windows);
        Thread t3 = new Thread(windows);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

