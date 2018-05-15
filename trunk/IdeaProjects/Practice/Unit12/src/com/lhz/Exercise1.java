package com.lhz;

/**
 * 编写一个异常类MyException, 再编写一个Student类，该类有一个产生异常的方法speak(int m)
 * 要求参数m大于1000时，抛出一个MyException对象
 */
public class Exercise1 {

    public void speak(int m){
        try {
            //异常判定
            if(m > 1000){
                //抛出异常
                throw new MyException("m 不能大于 1000");
            }else{
                System.out.println("m: " + m);
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Exercise1 exercise1 = new Exercise1();
        exercise1.speak(100);
        exercise1.speak(1001);
    }
}

//自定义异常类
class MyException extends Exception{
    MyException(String ErrorMessage){
        super(ErrorMessage);
    }
}