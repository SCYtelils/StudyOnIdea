package com.langsin;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 12:20
 */
public class Person {

    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("你好，我是一个人。");
    }

    public String showName(){
        System.out.println("我的名字是：" + name);
        return name;
    }
}
