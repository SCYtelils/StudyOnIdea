package com.langsin;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 12:28
 */
@SuppressWarnings("ALL")
public class ReflectionTest {

    /**
     * 反射之前，对于Person的操作
     */
    public void test1(){

        //1.创建Person类的对象
        Person p1 = new Person("Tom",12);

        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();
    }

    /**
     * 反射之后，对于Person的操作
     */
    public void test2() throws Exception{
        Class clazz = Person.class;
        //通过反，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(obj.toString());

        //通过反射，调用兑现指定的属性、方法
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(obj.toString());

        System.out.println("***************");

        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //通过反射，可以调用Person类的私有构造的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showName",String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国");
    }

    /**
     * 获取Class的实例对象
     */
    public void test3() throws ClassNotFoundException {
        //方法一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1);
        //方法二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(p1);
        //方法三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.langsin.Person");
        System.out.println(clazz3);
        //方法四：使用类加载器：ClassLoader
        ClassLoader classLoader = ReentrantLock.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.langsin.Person");
        System.out.println(clazz4);

        //结果为true，都是同一个对象
        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz1 == clazz4);
    }

    /**
     * Properties:用来读取配置文件
     */
    public void propertiesTest() throws IOException {

        Properties pros = new Properties();

        //读取配置文件方式一：
//        FileInputStream fis = new FileInputStream("ReflectTest/jdbc.properties");
//        pros.load(fis);

        //读取文件方式二：使用ClassLoader（配置文件默认识别为 当前module的src下）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user=" + user + ",password=" + password);

    }

    public static void main(String[] args) throws IOException {
        ReflectionTest re = new ReflectionTest();
        re.propertiesTest();
    }

}


