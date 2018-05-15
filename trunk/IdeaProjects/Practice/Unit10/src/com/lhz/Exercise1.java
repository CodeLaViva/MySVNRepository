package com.lhz;

abstract class Exercise_abstract {
    Exercise_abstract() {
        System.out.println("我是Exercise_abstract的 构造方法");
    }

    abstract void doExercise_abstract();
}

public class Exercise1 extends Exercise_abstract {

    Exercise1() {
        super();
        System.out.println("我是Exercise1的 构造方法");
    }

    @Override
    void doExercise_abstract() {
        System.out.println("实例化 Exercise_abstract的方法");
    }

    public static void main(String[] args){
        Exercise1 ex1 = new Exercise1();
        ex1.doExercise_abstract();
    }
}


