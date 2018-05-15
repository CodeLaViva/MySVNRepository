package com.lhz;

import java.util.Scanner;

//实现判断x为奇数还是偶数
//实现for循环打印菱形
//实现while循环 计算 1 + 1/2! + 1/3! + ...... + 1/20!之和
public class Exercise {
    public static void main(String[] args) {
        Exercise1();
        Exercise2();
        Exercise3();
    }

    //实现判断x为奇数还是偶数
    private static void Exercise1(){
        System.out.println("---------练习1-----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int x = scanner.nextInt();
        if (x % 2 == 0) {
            System.out.println("输入的数为偶数");
        } else {
            System.out.println("输入的数为奇数");
        }
    }

    //实现for循环打印菱形
    private static void Exercise2(){
        System.out.println("---------练习2-----------");
        //菱形上半部分
        //最大的for循环控制菱形的行
        for(int i = 0; i < 5; i++){
            //内部第一个for循环控制每行空格的输出
            for(int j = 0; j < 4 - i; j++){
                System.out.print(" ");
            }

            //内部第二个for循环控制每行*的输出
            for(int k = 0; k < 2 * i + 1; k++){
                System.out.print("*");
            }
            System.out.println("");
        }

        //菱形下半部分
        //最大的for循环控制菱形的行
        for(int i = 0; i < 4; i++){
            //内部第一个for循环控制每行空格的输出
            for(int j = 0; j < i + 1; j++){
                System.out.print(" ");
            }

            //内部第二个for循环控制每行*的输出
            for(int k = 0; k < 7 - 2 * i; k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    //实现while循环 计算 1 + 1/2! + 1/3! + ...... + 1/20!之和
    private static void Exercise3(){
        System.out.println("---------练习3-----------");
        double a = 0;
        int flag = 1, temp = 1; //定义 while判定参数 flag初始值为1， 定义临时数据temp初始值为1
        while (flag != 20) { //while判定 当flag不为20时，执行循环
            //for循环用以计算式中的分母
            for (int i = 1; i < flag + 1; i++) {
                temp = temp * i; //阶乘计算
            }
            a += 1.0 / temp; //将计算的分母进行计算，并且加到 和a上

            flag++; //flag变量自加1
            temp = 1; //初始化临时变量 temp
        }
        System.out.println("1 + 1/2! + 1/3! + ...... + 1/20! = " + a); //输出最终计算结果
    }
}