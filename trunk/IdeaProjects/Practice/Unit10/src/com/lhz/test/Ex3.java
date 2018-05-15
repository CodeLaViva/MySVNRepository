package com.lhz.test;

abstract class Ex_abstract{
    Ex_abstract(){
        super();
        System.out.println("我是Ex_abstract的 构造方法");
    }

    abstract void doEx_abstract();

    public static void doStatoc() {
        System.out.println("Ex_abstract的doStatoc");
    }
}

interface Ex_interface{
    void doEx_interface();
}

class Ex extends Ex_abstract implements Ex_interface{

    Ex(){
        super();
        System.out.println("我是Ex的 构造方法");
    }

    public static void doExercise(Ex ex){
    }

    @Override
    void doEx_abstract() {

    }

    @Override
    public void doEx_interface() {

    }

    public static void main(String[] args){
        Ex_abstract ex_a = new Ex_abstract() {
            @Override
            void doEx_abstract() {

            }
        };
    }
}

class Ex1 extends Ex{
    Ex1(){
        super();
        System.out.println("我是Ex1的 构造方法");
    }

}

class Ex3 extends Ex {
    Ex3(){
        super();
        System.out.println("我是Ex3的 构造方法");
    }
}