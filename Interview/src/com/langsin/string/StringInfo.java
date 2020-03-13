package com.langsin.string;

import java.io.Serializable;

/**
 * @author 🏹☂࿈秋鹜࿈🏹️
 * @create 2020/3/12 23:12
 */
public class StringInfo {
    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "1234";
        System.out.println(s1.compareTo(s2));
    }

    /**
     * String内部存储结构为char数组
     * abstract class String implements Serializable,Comparable<String>,CharSequence {
     *     //用于存储字符串的值
     *  private char value[];
     *     //缓字符串的hash code
     *      private int hash;
     *  }
     */

    /**
     * 1.String 多构造方法
     * //String为参数的构造方法
     * public String(String original){
     *     this.value = original.value;
     *     this.hash = original.hash;
     * }
     *
     * //char[]为参数的构造方法
     * public String(char value[]){
     *     this.value = Arrays.copyOf(value,value.length);
     * }
     *
     * //StringBuffer为参数的构造方法
     * public String(StringBuffer buffer){
     *     synchronized(buffer){
     *         this.value=Array.copyOf(buffer.getValue(),buffer.length())
     *     }
     * }
     *
     * //StirngBuilder为参数的构造方法
     * public String(StringBuilder builder){
     *      this.value = Arrays.copyOf(builder.getValue(),builder.length());
     * }
     */

    /**
     * 2.String中compareTo()和equals()方法的异同点
     *
     * 不同：
     *  equals()可以接收一个Object类型的参数，而compareTo只能接收String类型的参数
     *  equals()返回值为Boolean，而compareTo()的返回值则为int
     * 相同：
     *  都可以用于两个字符串的比较
     *
     *  当equals()方法返回true时，或是compareTo()方法返回0时，则表示两个字符串完全相同
     *
     *
     * equals源码：
     * String重写了Object类中的构造方法
     * public boolean equals(Object anObject){
     *      //对象引用相同直接返回true
     *      if(this==anObject){
     *          return true;
     *      }
     *      //判断需要对比的值是否为String类型，如果不是则返回false
     *      if(anObject instanceof String){
     *          String anotherString = (String)anObject;
     *          int n = value.length;
     *          if(n==anotherString.value.length){
     *              //把两个字符串都转化为char数组对比
     *              char v1[]=value;
     *              char v2[]=anotherString.value;
     *              int i=0;
     *              //循环比对两个字符串的每一个字符
     *              while(n--!=0){
     *                  //如果其中有一个字符不相等就true false，否则继续对比
     *                  if(v1[i]!=v2[i])
     *                      return false;
     *                  i++;
     *              }
     *              return true;
     *          }
     *      }
     *      return false;
     * }
     *
     * String的compareTo()方法:
     *  循环对比所有的字符，当两个字符串中有任意一个字符不相同的时候，返回两个字符的差值
     * 源码：
     * public int compareTo(String anotherString){
     *      int len1 = value.length;
     *      int len2 = anotherString.value.length;
     *      //获取到两个字符串长度最短的那个int值
     *      int lim = Math.min(len1,len2);
     *      char v1[]=value;
     *      char v2[]=anotherString.value;
     *      int k=0;
     *      //对比每一个字符
     *      while(k<lim){
     *          char c1=v1[k];
     *          char c2=v2[k];
     *          if(c1!=c2){
     *              //有字符不相等就返回差值
     *              return c1-c2;
     *          }
     *          k++;
     *      }
     *      //检验长度
     *      return len1-len2;
     * }
     */

    /**
     * 3.String的常用方法
     *
     * indexOf():查询字符串首次出现的下标位置
     * lastIndexOf():查询字符串最后出现的下标位置
     * contains(): 查询字符串中是否包含另一个字符串
     * toLowerCase(): 把字符串全部转换成小写
     * toUpperCase(): 把字符串全部转换成大写
     * length(): 查询字符串的长度
     * trim(): 去掉字符串首尾空格
     * replace():替换字符串中的某些字符
     * split(): 把字符串分割并返回字符串数组
     * join(): 把字符串数组专为字符串
     */

    /**
     * 知识扩展
     * 1.== 和 equals 的区别
     *      ==对于基本数据来说，是用于比较”值 “是否相等的
     *      而对于引用类型来说，是用与比较引用地址是否相同的
     *      String类型的equals()是重写了object类，他的基本实现是靠==
     *      public boolean equals(Object obj){
     *
     *          return (this==obj);
     *
     *      }
     *2.final修饰的好处（James Gosling回答）
     *      （1）安全
     *      迫使String类设计成不可变的另一个原因是安全（在进行系统校验时，如果可变，有可能会出现严重的系统崩溃问题）
     *      举例：字符串常量池
     *      （2）高效
     *      他会更倾向于使用不可变类（final），因为它能够缓存结果，当你在传参时不需要考虑谁会修改它的值
     *      如果是可变类的话，则有可能需要重新拷贝出来一个新值进行传参，这样性能上就会有一定的损失。
     * 3.String和StringBuilder、StringBuffer的区别
     *      String类型是不可变的
     *      所以在字符串拼接的时候如果使用String的话性能会很低
     *      因此就需要使用另一个数据类型StringBuffer
     *          它提供了append和insert方法可用于字符串的拼接
     *          它使用了synchronized来保证线程安全
     *          源码：
     *          public synchronized StringBuffer append(Object obj){
     *              toStringCache = null;
     *              super.append(String.valueOf(obj));
     *              return this;
     *          }
     *          public synchronized StringBuffer append(String str){
     *              toStringCache = null;
     *              super.append(String.valueOf(str));
     *              return this;
     *          }
     *      由于StringBuffer保证了线程安全，所以性能上较低
     *      jdk1.5推出了StringBuilder,功能和StringBuffer一样，但线程安全，性能高。
     *
     * 4.String 常见的创建方式有两种
     *      方法一：String s1 = "java";  直接赋值
     *      方法二：String s2 = new String("java");  对象创建
     *      两种方法在JVM的存储区域中截然不同
     *      方法一jvm会先到字符串常量池中寻找是否有相同的字符串，如果有就返回常量句柄；
     *      如果没有该字符串，就先在常量池中创建此字符串，然后再返回常量句柄
     *      方法二直接在堆中创建此字符串，只有调用intern()才会放入字符串常量池中
     *      检验代码：
     *      String s1 = new String("java");
     *      String s2 = s1.intern();
     *      String s3 = "java";
     *      System.out.println(s1==s2); //false
     *      System.out.println(s2==s3); //true
     *      //s2,s3指向堆中常量池的“java”，s1指向堆中“java”对象
     *      （jdk1.7之后把永生代换成了元空间，把字符串常量池从方法区移到了Java堆上）
     *
     * 5.编译器还会对String字符串做一些优化
     *      String s1 = "ja" + "va";
     *      String s2 = "java";
     *      System.out.println(s1==s2); //true
     */
}








