package com.langsin.exer;

/**
 * 银行有一个账户，
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次，每次存完打印账余额
 *
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/6 22:19
 */

//账户（共享数据）
class Account{

    private double balance;
    public Account(double balance){
        this.balance =balance;
    }

    //存钱
    public synchronized void deposit(double amt){

        if (amt > 0){
            balance += amt;
            System.out.println(Thread.currentThread().getName() + "：存钱成功！当前余额为：" + balance);
        }
    }
}

//储户（线程）
class Customer implements Runnable{

    private Account acct;
    //初始化数据
    public Customer(Account acct){
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            acct.deposit(1000);
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer customer = new Customer(acct);
        Thread c1 = new Thread(customer);
        Thread c2 = new Thread(customer);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
