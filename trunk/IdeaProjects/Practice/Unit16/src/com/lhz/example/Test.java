package com.lhz.example;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test {
    private String name_private = "Test_private";
    public String name_public = "Test_public";
    protected String name_protected = "Test_protected";
    public String name_public2 = "Test_public2";


    public Test(){
        System.out.println("这是Test的构造方法");
    }

    public void function1(){
        System.out.println("这是Test的function1");
    }

    protected void function2(){
        System.out.println("这是Test的function2");
    }

    private void function3(){
        System.out.println("这是Test的function3");
    }

    private static void fanxing_test(){
        //泛型的作用是在编译阶段防止错误输入，绕过编译就绕过了泛型
        //反射都是绕过编译操作
        ArrayList<String> str = new ArrayList<String>();
        str.add("你好！");
        ArrayList str2 = new ArrayList();

        //结果是true说明类类型是一样的，编译后是去泛型化的
        System.out.println(str.getClass() == str2.getClass());
        System.out.println(str.getClass() == ArrayList.class);

        //用add方法的反射
        try {
            Method method = str.getClass().getMethod("add", new Class[]{Object.class});
            method.invoke(str, new Object[]{100});
            method.invoke(str, new Object[]{"123"});
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(str.size());
        System.out.println(str);

        for (String s : str) {
            System.out.println(s);
        }
    }
}
