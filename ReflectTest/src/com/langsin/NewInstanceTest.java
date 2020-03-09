package com.langsin;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

/**
 * 通过反射创建对应的运行时类的对象
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 19:53
 */
public class NewInstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建对应的运行时类的对象
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }
}
