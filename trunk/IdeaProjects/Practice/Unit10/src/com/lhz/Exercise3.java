package com.lhz;

abstract class Exercise3_parent{
    Exercise3_parent() {
        super();
        System.out.println("首先调用父类构造方法");
        System.out.println("在父类的构造方法中调用doSomething();");
        doSomething();
        System.out.println("在父类的构造方法中调用doExercise3_parent();");
        doExercise3_parent();
        //System.out.println("我是Exercise3_parent的 构造方法");
    }

    abstract void doSomething();

    abstract void doExercise3_parent();
}

class Exercise3_test extends Exercise3_parent{
    @Override
    void doSomething() {
        System.out.println("我是子类Exercise3_test实例化的doSomething");
    }

    @Override
    void doExercise3_parent() {
        System.out.println("我是子类Exercise3_test实例化的doExercise3_parent");
    }
}

public class Exercise3 extends Exercise3_parent{
    private static int flag = 1;

    private Exercise3() {
        super();
        System.out.println("之后调用子类构造方法");
        //System.out.println("我是Exercise3的 构造方法");
        System.out.println("在子类的构造方法中调用doSomething();");
        doSomething();
        System.out.println("在子类的构造方法中调用doExercise3_parent();");
        doExercise3_parent();
    }

    @Override
    void doSomething(){
        System.out.println("我是子类实例化的doSomething" + flag);
        flag++;
    }

    @Override
    void doExercise3_parent() {
        System.out.println("我是子类实例化的doExercise3_parent" + flag);
        flag++;
    }

    public static void main(String[] args){
        new Exercise3_test();
        //new Exercise3();
    }
}
