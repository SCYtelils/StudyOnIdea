package com.langsin.java1;

/**
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者（Productor）将产品交给店员（Clerk），而消费者（Customer）从店员处取走产品
 * 店员一次只能持有固定数量的产品（比如：20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，
 * 如果店中有产品了再通知消费者来取走产品
 *
 * 分析：
 * 1.是否是多线程问题？是，生产者线程，消费者线程
 * 2.是否有共享数据？是，店员（或产品）
 * 3.如何解决现成的安全问题？同步机制，有三种方法
 * 4.是否设计线程的通信？是
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/7 11:04
 */
class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() {
        if (productCount<20){
            productCount++;
            System.out.println(Thread.currentThread().getName() + "：正在生产第" + productCount + "个产品");
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct(){
        if (productCount>0){
            System.out.println(Thread.currentThread().getName() + "：正在消费第" + productCount + "个产品");
            productCount--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer implements Runnable{//生产者

   private Clerk clerk;

    public Producer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始生产产品....");

        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }
    }
}

class Consumer implements Runnable{//消费者

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始消费产品....");

        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}

public class Product {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer producer = new Producer(clerk);
        Thread p1 = new Thread(producer);
        p1.setName("生产者1");

        Consumer consumer = new Consumer(clerk);
        Thread c1 = new Thread(consumer);
        c1.setName("消费者1");
        Thread c2 = new Thread(consumer);
        c2.setName("消费者2");

        p1.start();
        c1.start();
        c2.start();
    }


}
