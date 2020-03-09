package com.langsin;

import com.sun.corba.se.impl.orb.ParserTable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 12:28
 */
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
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class,int.class);

        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(obj.toString());
    }
}


