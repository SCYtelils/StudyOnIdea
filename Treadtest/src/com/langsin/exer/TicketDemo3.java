package com.langsin.exer;

/**
 *
 * 问题：三个窗口卖100张票，用线程解决。
 *
 * 用线程同步方法解决线程安全问题
 * 注意：此时的同步监视器(锁)不再是this，而是.class对象
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/5 17:50
 */

class TicketTread3 extends Thread{

    //保证多个线程共用一份数据，需要设置成静态的
    public static int ticket = 100;
    //同一把锁
    public static Object object = new Object();

    @Override
    public void run() {
        while (true){
            //正确的

        }

    }

    //为了锁的唯一，需要用静态定义方法
    //此时锁为Windows3.class
    public static synchronized void show(){
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


public class TicketDemo3 {
    public static void main(String[] args) {
        TicketTread3 t1 = new TicketTread3();
        TicketTread3 t2 = new TicketTread3();
        TicketTread3 t3 = new TicketTread3();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
