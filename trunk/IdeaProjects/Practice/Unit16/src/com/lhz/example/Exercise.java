package com.lhz.example;

import java.lang.reflect.Method;

public class Exercise {

    public static void main(String[] args) {
        function();
    }

    public static void function(){
        Test test_ = new Test();
        Class test = test_.getClass();
        test.getConstructors();

        /*Constructor[] con = test.getDeclaredConstructors();
        for(int i = 0; i < con.length; i++){
            System.out.println(con[i]);
        }*/

        //有时并没有按照定义顺序返回
        Method[] m = test.getDeclaredMethods();
        for(int i = 0; i < m.length; i++){
            System.out.println(m[i]);
        }

        /*Field[] c = test.getFields();
        for(int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }

        Field[] d = test.getDeclaredFields();
        for(int i = 0; i < d.length; i++){
            System.out.println(d[i]);
        }
*/
    }
}
