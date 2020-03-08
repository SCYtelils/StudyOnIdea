package com.langsin.java;

/**
 * 实现线程的第二种方式
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/5 18:08
 */

class MThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.start();
    }
}
