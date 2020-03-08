package com.langsin.java1;

/**
 * 线程通信的例子：两个线程打印1-100，交替打印
 *
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器（锁）
 * notify():一旦执行此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个。
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的线程。
 *
 * 说明：
 * 1.三个方法必须使用在同步代码块或同步方法中
 * 2.三个方法的调用者，必须是同步代码块或同步方法中的同步监视器（锁为调用者，只有锁才能调用三个方法）
 *    否则，会出现IllegalMonitorStateException异常
 * 3.三个方法定义在java.lang.Object类中
 *
 * 面试题：sleep() 和 wait() 的异同？
 * 1.相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 * 2.不同点：1）两个方法声明的位置不同：Thread类中声明sleep(),Object类中声明wait()
 *         2）调用的要求不同：sleep()可以在任何需要的场景下调用。wait()必须在同步代码块和同步方法中使用
 *         3）关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep()不会释放锁，wait()会释放锁
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/6 22:41
 */

class Number implements Runnable{

    private int number = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                //使用notify()方法唤醒线程
//              this.notify();
                notify();
                if (number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":数字：" + number);
                    number++;

                    try {
                        //使用wait()方法使得线程处于阻塞状态
//                      this.wait();
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}

public class Communicate {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
