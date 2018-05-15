package com.lhz;

import java.text.DecimalFormat;

public class Exercise {

    //获取2-32之间的随机偶数
    public static int GetEvenNum(double num1, double num2) {
        int s = (int) num1 + (int) (Math.random() * (num2 - num1));
        if (s % 2 == 0) {
            return s;
        } else {
            return s + 1;
        }
    }

    //计算圆的面积，输出结果保留五位小数
    public static void Calculate_circle(double banjing){
        double area;
        area = Math.PI * banjing * banjing;
        DecimalFormat myFormat = new DecimalFormat("#.00000");
        System.out.println("半径为" + banjing + "的圆面积为： " + myFormat.format(area));
        //return 1.0;
    }

    public static void DecimalMethod(){
        DecimalFormat myFormat = new DecimalFormat();
        myFormat.setGroupingSize(2); // 将数字每两个进行分组
        String output = myFormat.format(123456.789);
        System.out.println("将数字每两个分组： " + output);
        myFormat.setGroupingUsed(false); //设置不允许数字分组
        String output2 = myFormat.format(123456.789);
        System.out.println("不允许数字分组： " + output2);
    }

    public static void main(String[] args) {
        System.out.println("-----------获取2-32间随机六个偶数并求和----------");
        int total = 0;
        for(int i = 0; i < 6; i++){
            int temp = GetEvenNum(2, 32);
            System.out.println("第" + (i + 1) + "个数为：" + temp);
            total += temp;
        }
        System.out.println("六个 2-32的随机偶数的和为： " + total);

        System.out.println("-----------输入半径，输出圆的面积，结果保留五位小数----------");
        Calculate_circle(2.0);

        DecimalMethod();
    }
}
