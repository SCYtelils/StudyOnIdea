package com.langsin.exer;

/**
 * 练习：创建两个分线程，一个遍历100以内的偶数，一个遍历100以内的奇数
 */
public class TreadDemo {

    public static void main(String[] args) {
//        MyTread1 myTread1 = new MyTread1();
//        MyTread2 myTread2 = new MyTread2();
//        myTread1.start();
//        myTread2.start();

        //如果只想简单的开启一次多线程，并且不复用的可以使用匿名内部类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}

class MyTread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class MyTread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2!=0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


