package com.lhz;

abstract class my_test{
    my_test(){
        function();
    }

    abstract void function();
}

public class test extends my_test {

    test(){
        super();
    }

    @Override
    void function() {
        System.out.println("我是继承类");
    }

    public static void main(String[] args) {
        test test = new test();
    }
}
