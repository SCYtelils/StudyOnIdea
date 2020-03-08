package com.langsin.exer;

/**
 * 用同步代码块解决线程安全问题
 *
 * 问题：三个窗口卖100张票，用线程解决。
 *
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/5 17:50
 */

class TicketTread extends Thread{

    //保证多个线程共用一份数据，需要设置成静态的
    public static int ticket = 100;
    //同一把锁
    public static Object object = new Object();

    @Override
    public void run() {
        while (true){
            //正确的
            synchronized (object){
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(TicketTread.currentThread().getName() + ":正在售卖第" + ticket + "张票");
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}


public class TicketDemo {
    public static void main(String[] args) {
        TicketTread t1 = new TicketTread();
        TicketTread t2 = new TicketTread();
        TicketTread t3 = new TicketTread();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
