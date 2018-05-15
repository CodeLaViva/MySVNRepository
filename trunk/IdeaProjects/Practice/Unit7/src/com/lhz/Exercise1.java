package com.lhz;

public class Exercise1 {
    //编写一个类，定义一个private成员变量，两个成员方法，一个方法实现此变量的赋值，另一个获取该值
    private String Exercise1_temp;

    public void Exercise1_tempSet(String Exercise1_temp) {
        this.Exercise1_temp = Exercise1_temp;
    }

    public String Exercise1_tempGet() {
        return this.Exercise1_temp;
    }

    public static void main(String[] args) {
        Exercise1 ex = new Exercise1();
        ex.Exercise1_tempSet("设置参数");
        System.out.println(ex.Exercise1_tempGet());

    }
}
