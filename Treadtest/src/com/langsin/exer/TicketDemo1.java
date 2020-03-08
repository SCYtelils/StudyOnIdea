package com.langsin.exer;

/**
 * 卖票问题，多线程利用runnable接口实现
 * 线程安全问题：
 *  1.有几率出现错票和重票
 * 原因：在线程被阻塞时，其他线程也在使用共享数据，因此出现错票重票问题
 *
 * 方法一：同步代码块：
 *      线程同步机制：
 *      当某一个线程在使用共用的数据（执行被同步的代码）时，其他线程要进行等候，无论这个线程是否处于阻塞状态。
 *      举例：公共厕所
 *      synchronized(同步监视器（锁）){
 *          //要被同步的代码
 *      }
 *
 *      说明：
 *             1.操作 共享数据的代码即为要被同步的代码
 *            2.共享数据：多个线程要共同操作的同一个数据，例如：ticket
 *           3.同步监视器，俗称锁，任意一个类的对象都可担任
 *           要求：多个线程必须共用同一把锁
 *
 *      同步的方式，解决了线程安全的问题 --好处
 *      操作代码时，只能有一个线程参与，其他线程等待。相当于一个单线程过程，效率低
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/5 18:18
 */

class Windows implements Runnable{

    //这里无需设定静态变量，因为多个线程调用同一个接口
    public int ticket = 100;
    Object object = new Object();

    @Override
    public void run() {
        while (true){
            //线程同步机制
//            方式一：synchronized(object){
            //方式二：用this动态指代，只创建一个对象，所以可以这样指代
//            synchronized (this){
            //方法三：用类的对象
            synchronized (Windows.class){
                if (ticket>0){

                    //进行线程休眠后会遇到负数票的问题，并且更容易出现票重复的问题
                    //阻塞后会提升线程切换的概率
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(TicketTread.currentThread().getName() + ":正在售卖第" + ticket + "张票");
                    ticket--;
                }else {
                    break;
                }
            }
        }

    }
}


public class TicketDemo1 {
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
