package com.langsin.java1;

/**
 * 用线程同步的方法解决单例模式的线程安全问题
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/6 16:32
 */
public class BankDemo {
}

class Bank{
    //单例模式（private构造方法，确保该类使用对象唯一）
    private Bank(){};

    public static Bank instence = null;

    //此处可能引发线程安全问题
    public static Bank getInstence(){

        //方式一，效率稍差（线程全部同步）
//        synchronized (Bank.class) {
//            if (instence==null){
//                instence = new Bank();
//            }
//        return instence;
//        }
        //方式二：效率较高(一小部分线程同步)
        if (instence==null){
            synchronized (Bank.class) {
                if (instence==null){
                    instence = new Bank();
                }
            }
        }
        return instence;
    }
}


