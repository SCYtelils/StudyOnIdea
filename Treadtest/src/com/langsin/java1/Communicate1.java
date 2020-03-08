package com.langsin.java1;
/**
 * 两个线程打印1-100，交替打印
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/6 22:41
 */

class Number1 implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                if (number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":数字：" + number);
                    number++;
                }else {
                    break;
                }
            }
        }
    }
}

public class Communicate1 {
    public static void main(String[] args) {
        Number1 number = new Number1();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
