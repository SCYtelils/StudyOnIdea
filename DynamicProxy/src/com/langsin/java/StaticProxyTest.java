package com.langsin.java;

/**
 * 静态代理举例
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/10 9:18
 */
interface ClothFactory{

    void produceCloth();

}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{

    /**
     *  用被代理类对象进行实例化
     */
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工程做一些后续的收尾工作");
    }
}

/**
 * 被代理类
 */
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();
    }
}
