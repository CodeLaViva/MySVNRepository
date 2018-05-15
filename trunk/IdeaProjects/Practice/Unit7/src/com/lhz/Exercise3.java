package com.lhz;

public class Exercise3 {
    public static void main(String[] args) {
        //使用IDEA赋值args通过 Run-》Edit Configurations 的 Program Argument进行设置
        int length = args.length;
        for (int i = 0; i < length; i++) {

            System.out.println("args的值： "  + args[i] + "i的值： " + i);
        }
    }
}
