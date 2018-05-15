package com.lhz;

import java.util.Random;

import static java.lang.Math.max;
import static java.lang.System.out;

class Test {
    int i = 1;
}

class FinalData {
    static Random rand = new Random();
    private final int VALUE_1 = 9;
    private static final int VALUE_2 = 10;
    private final Test test1 = new Test();
    private Test test2 = new Test();
    private final int[] a = {1, 2, 3, 4, 5, 6};
    private final int i4 = rand.nextInt(20);//每一次调用会重新执行rand进行复制
    private static final int i5 = rand.nextInt(20);//只有第一次执行会使用rand进行赋值，以后直接调用第一次的赋值y

    public String toString() {
        return "i4: " + i4 + "\ti5: " + i5 + "";
    }

    public static void main(String[] args) {
        FinalData data = new FinalData();
        data.test1.i = 2; //可以对final修饰的成员变量赋值
        //data.test1 = new Test(); 无法执行，因为被final修饰

        //data.VALUE_1++; 无法执行，因为被final修饰
        out.println(" " + max(1, 4) + "" + VALUE_2 + "" + i5);

        out.println(data);

        out.println("data2");

        out.println(new FinalData());
    }
}

public class Exercise_test {
    private static int flag = 0;

    Exercise_test() {
        System.out.println("Exercise_test 构造方法" + " flag = " + flag++);
    }

    innerClass innerClass = new innerClass();

    public void outf(){
        innerClass.innerFunction();
    }

    private class innerClass {
        innerClass() {
            System.out.println("innerClass 构造方法" + " flag = " + flag++);
        }

        void innerFunction() {
            System.out.println("innerClass Function" + " flag = " + flag++);
        }

        int innerNum = 1;

    }

    private innerClass doit(){
        innerClass.innerNum = 4;
        return innerClass;
    }

    public static void main(String[] args) {
        Exercise_test out = new Exercise_test();

        //内部类的对象实例化操作必须在外部类或外部类非静态方法中实现
        Exercise_test.innerClass in = out.doit();
        System.out.println(in.innerNum);
        Exercise_test.innerClass in2 = out.new innerClass();
    }

}
