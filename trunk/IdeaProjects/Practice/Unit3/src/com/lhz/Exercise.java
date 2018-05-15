package com.lhz;

//实现输出两个整数a， b之和
//对比局部变量、成员变量、final修饰关键字
public class Exercise {

    public static void main(String[] args){
        Exercise1();
        Exercise2();
    }


    private static void Exercise1(){
        System.out.println("---------练习1-----------");
        int a = 10;
        int b = 20;
        System.out.println("a + b 的和为：" + (a + b));
    }

    //对比局部变量、成员变量、final修饰关键字
    private static int x = 10; //定义私有的静态成员变量X
    private static final int a = 20; //final修饰的成员变量必须初始化

    private static void Exercise2(){
        System.out.println("---------练习2-----------");
        int x = 20; //定义局部变量X，此时成员变量X被隐藏
        System.out.println("x = " + x); // 此时输出为局部成员变量X， 值为20
        test();
    }

    private static void test(){
        final int a;
        a = 10;
        //a = 20; final定义的局部变量只能赋一次值
        System.out.println("x = " + x); // 此时输出成员变量x， 值为10
        System.out.println("a = " + a); // 此时输出局部变量a， 值为10
    }
}
