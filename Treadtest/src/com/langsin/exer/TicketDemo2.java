package com.langsin.exer;

/**
 * 卖票问题，多线程利用runnable接口实现
 * 线程安全问题：
 *  1.有几率出现错票和重票
 * 原因：在线程被阻塞时，其他线程也在使用共享数据，因此出现错票重票问题
 *
 * 线程安全解决二：同步方法，将共用的代码定义为一个方法，在方法上定义synchronized
 * 注意：这个时候还是有同步监视器（锁），默认为this
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/5 18:18
 */

class Windows1 implements Runnable{

    //这里无需设定静态变量，因为多个线程调用同一个接口
    public int ticket = 100;
    Object object = new Object();

    @Override
    public void run() {
        while (true){
               show();
        }

    }

    public synchronized void show(){
        if (ticket>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(TicketTread.currentThread().getName() + ":正在售卖第" + ticket + "张票");
            ticket--;
        }
    }
}


public class TicketDemo2 {
    public static void main(String[] args) {
        Windows1 windows = new Windows1();
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
