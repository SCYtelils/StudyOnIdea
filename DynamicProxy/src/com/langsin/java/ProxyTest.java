package com.langsin.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的举例
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/10 14:03
 */
interface Human{

    /**
     * 获得信仰
     * @return
     */
    String getBelief();

    /**
     * 吃东西
     * @param food
     */
    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/**
 * 代理利用举例：相同代码块灵活复用
 * 情景：当我们想同时调用静态和动态的方法时（AOP）
 * 你是肯德基的厨师，有两个个客人，分别要劲脆鸡腿堡和香辣鸡腿堡。
 * 你想了想，需要相同的面包片，还要不同的汉堡肉，于是你就在invoke()方法中调用了面包片
 * 中间是代理的方法，就是汉堡肉
 */
class HumanUtil{

    public void method1(){
        System.out.println("=============通用方法一=============");
    }
    public void method2(){
        System.out.println("=============通用方法二=============");
    }
}


/*
想要实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */

class ProxyFactory{
    /**
     * 调用此方法，返回一个代理类的对象。解决问题一
     */
    public static Object getProxyInstance(Object obj){
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    /**
     * 需要使用被代理类的对象进行赋值
     */
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }

    /**
    当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    将被代理类要执行的方法a的功能生命在invoke()中
     是一个通用的方法代理模板
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        /*
        method:即为代理类对象调用的方法，此方法也就作为了被代理类对象调用的方法
        obj:被代理的对象
         */
        Object returnValue = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中invoke()方法的返回值
        return returnValue;
    }
}


/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 */
public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance:代理类对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类调用方法时，会自动的调用被代理类中同名的方法
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println("***************************");

        NikeClothFactory nikeClothFactory = new NikeClothFactory();

        ClothFactory proxyClothFactory = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);

        proxyClothFactory.produceCloth();
    }
}
