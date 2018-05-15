package com.lhz;

class Exercise2_parent{
    Exercise2_parent(){
        super();
        System.out.println("我是Exercise2_parent的 构造方法");
    }

    void doSomething1(Exercise2_parent ep){
        System.out.println("Exercise2_parent 的 doSomething1");
    }

    public void doSomething2(){
        System.out.println("Exercise2_parent 的 doSomething2");
    }
}

public class Exercise2 extends Exercise2_parent{
    private Exercise2(){
        super();
        System.out.println("我是Exercise2的 构造方法");
    }

    public void doSomething2(){
        System.out.println("我是Exercise2的 doSomething2");
    }

    public static void main(String[] args){
        Exercise2 ex2 = new Exercise2();
        //向上转型到基类
        ex2.doSomething1(ex2);
        ex2.doSomething2();
    }
}