package com.lhz;

import java.util.Scanner;

public class Exercise2 {
    private int length, width;

    public Exercise2() {

    }

    public Exercise2(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int calculate() {
        return this.length * this.width;
    }

    public static void main(String[] args) {
        Exercise2 ex2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入矩形的长和宽：");
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        ex2 = new Exercise2(length, width);
        int area = ex2.calculate();
        System.out.println("矩形的面积为： " + area);

        Exercise1 ex1 = new Exercise1();
        ex1.Exercise1_tempSet("我来自Exercise2");
        System.out.println(ex1.Exercise1_tempGet());
    }
}
