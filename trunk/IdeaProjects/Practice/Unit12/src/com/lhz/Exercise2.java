package com.lhz;

/**
 * 创建一个Computer类，该类中有一个计算两个数最大公约数的方法，如果
 * 向该方法传递复数，就抛出自定义异常
 */
public class Exercise2 extends Exception {

    Exercise2(String errorMessage) {
        super(errorMessage);
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.function(5, 10);
        computer.function(10, -1);
        computer.function(0, 20);
    }
}

class Computer {
    void function(int num1, int num2) {
        try {
            if(num1 <= 0 || num2 <= 0){
                throw new Exercise2("进行公约数计算的两个数必须是大于0 的整数");
            }
            //辗转相除法计算最大公约数
            int cal_num1 = num1;
            int cal_num2 = num2;
            while (cal_num2 != 0) {
                int temp_num = cal_num1 % cal_num2;
                cal_num1 = cal_num2;
                cal_num2 = temp_num;
            }
            System.out.println(num1 + "与" + num2 + "的最大公约数是" + cal_num1);
        } catch (Exercise2 e) {
            e.printStackTrace();
        }
    }
}
