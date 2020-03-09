package com.langsin.java;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/9 12:20
 */
public class Person {

    private  String name;
    public int age;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String showName(String name){
        System.out.println("我的名字是：" + name);
        return name;
    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }
}
