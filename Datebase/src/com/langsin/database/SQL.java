package com.langsin.database;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/14 21:47
 */
public class SQL {
    /**
     * ### MySQL服务的登录和退出
     * mysql -h主机名 -P端口号 -u用户名 -p密码
     * exit或ctrl+C
     */

    /**
     * ###MySQL的常见命令
     * 1.查看当前所有的数据库
     * show databases;
     * 2.打开指定的库
     * use 库名
     * 3.查看当亲阿库的所有表
     * show tables;
     * 4.查看其他库的所有表
     * show tables from 库名;
     * 5.创建表
     * create table 表名(
     *      列名 列类型,
     *      列名 列类型,
     *      ...
     * )
     * 6.查看表结构
     * desc 表名;
     * 7.查看服务器的版本
     * select version();
     *
     * ###  MySQL的语法规范
     * 1.不区分大小写，但是建议关键字大写，表名、列名小写
     * 2.每条命令最好用分号节为
     * 3.每条命令根据需要，可以进行缩进 或换行
     * 4.注释
     *      单行注释：#注释文字
     *      单行注释：-- 注释文字
     *      多行注释：/* 注释文字 */

//   # 进阶1：基础查询
///*
//语法：
//select 查询列表 from 表格;
//
//类似于：System.OUT.println(打印东西);
//
//特点：
//
//1、查询列表可以是：表中的字段、常量值、表达式、函数
//2、查询的结果是一个虚拟的表格
//*/
//
//#切换数据库
//
//    USE myemployees;
//
//#1.查询表中的单个字段
//
//    SELECT last_name FROM employees;
//
//#2.查询表中的多个字段：用“,”隔开
//
//    SELECT last_name,salary,email FROM employees;
//
//#3.查询表中所有数据
//
//    SELECT * FROM employees;
//
//#4.查询常量值
//
//    SELECT 100;
//    SELECT 'john';
//
//#5.查询表达式
//    SELECT 100*98;
//
//#6.查询函数
//    SELECT VERSION();
//
//#7.起别名
///*
//1）便于理解
//2）如果要查询的字段有重名的情况，可以使用别名区分开来
//*/
//#方式一：使用AS
//    SELECT 100%98 AS 结果;
//    SELECT last_name AS 姓,first_name AS 名 FROM employees;
//#方式二：使用空格
//    SELECT last_name 姓,first_name 名 FROM employees;
//
//#案例：查询salary，现实结果为out put
//    SELECT salay AS "out put" FROM employees;
//
//#8.去重
//
//#案例：查询员工表中涉及到的所哟有的部门编号
//    SELECT DISTINCT department_id FROM employees;
//
//#9.+号的作用
///*
//mysql中的+号：
//仅仅只有一个功能：运算符
//
//SELECT 100+90; 两个操作数都是数值型，则做加法运算
//SELECT '123'+90; 只要其中一方为字符型，试图将字符型数值转换成数值型
//									如果转换成功，则继续做加法运算
//SELECT 'john'+90;如果转换失败，则将字符型数值转换成0
//
//SELECT null+10; 只要其中一方为null，则结果肯定为null
//*/
//
//#案例：查询员工名和姓链接成一个字段，并显示为 姓名
//    SELECT CONCAT(last_name,first_name) AS 姓名 FROM employees;

}
