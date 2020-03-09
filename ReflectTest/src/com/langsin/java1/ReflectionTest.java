package com.langsin.java1;

import com.langsin.java.Person;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 21:54
 */
public class ReflectionTest {
    /**
     由于public并不常用，所以该方法不常用
     */
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //获取指定的属性：要求运行时类中属性声明为public。这种方法不常用
        Field id = clazz.getField("id");

        /*
        设置当前属性的值
        set():参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少
         */
        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    /**
    如何操作运行时中的指定的属性 == 需要掌握
     */
    @Test
    public void testField1() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        //getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //保证当前属性是可访问的
        name.setAccessible(true);
        //获取、设置指定对象的此属性值
        name.set(p,"Tom");

        System.out.println(name.get(p));
    }

    /**
    如何操作运行时类中的指定的方法 -- 需要掌握
     */
    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class clazz = Person.class;

        //创建运行时类的对象
        Person p = (Person) clazz.newInstance();

        /*
        获取指定的某个方法
        getDeclaredMethod():参数1：指明获取的方法的名称 参数2：指明获取的方法的形参列表
         */
        Method showName = clazz.getDeclaredMethod("showName", String.class);
        showName.setAccessible(true);
        /*
        invoke():参数1：方法的调用者  参数2：给方法形参赋值的实参
        invoke()的返回值即为对应类中调用的方法的返回值
         */
        Object returnValue = showName.invoke(p, "老王");
        System.out.println(returnValue);

        System.out.println("*****************如何调用静态方法****************");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        /*
        如果调用的运行时类中的方法没有返回值，则此invoke()返回null
        调用静态方法时invoke()的参数可以省略
         */
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);

    }

    /**
     * 如何调用运行时类中的指定的构造器
     * 用的较少，newInstance()的多
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Person.class;

        /*
        获取指定的构造器
        getDeclaredConstructor():参数：指明构造器的参数列表
         */
        Constructor constructor = clazz.getDeclaredConstructor(String.class);

        //保证此构造器时可访问的
        constructor.setAccessible(true);

        //调用此构造器创建运行时类的对象
        Person person = (Person) constructor.newInstance("Tom");
        System.out.println(person);

    }
}
