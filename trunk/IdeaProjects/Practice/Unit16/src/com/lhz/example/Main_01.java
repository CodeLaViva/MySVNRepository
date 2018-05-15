package com.lhz.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main_01 {

    public static void constructors_Test(){
        Example_01 example = new Example_01("10", "20", "30");
        Class<? extends Example_01> exampleC = example.getClass();
        //获得所有的构造方法
        Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
        //遍历构造方法

        for(int i = 0 ;i < declaredConstructors.length; i++){
            System.out.println(declaredConstructors[i]);
        }

        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor<?> constructor = declaredConstructors[i];
            System.out.println("当前构造方法的名字为： " + constructor.getName());
            System.out.println("查看是否允许带有可变数量的参数： " + constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次为： ");
            Class[] parameterTypes = constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" " + parameterTypes[j]);
            }
            System.out.println("该构造方法可能抛出的异常类型为： ");
            //获得所有可能抛出的异常信息类型
            Class[] exceptionTypes = constructor.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(" " + exceptionTypes[j]);
            }

            Example_01 example2 = null;

            while (example2 == null) {
                //如果该成员变量的访问权限为private，则抛出异常，即不允许访问
                try {
                    if (i == 2) {
                        //通过执行默认没有参数的构造方法创建对象
                        example2 = (Example_01) constructor.newInstance();
                    } else if (i == 1) {
                        //通过执行具有两个参数的构造方法创建对象
                        example2 = (Example_01) constructor.newInstance("7", 5);
                    } else {
                        //通过执行具有可变参数的构造方法创建对象
                        Object[] parameters = new Object[]{new String[]{"100", "200", "300"}};
                        example2 = (Example_01) constructor.newInstance(parameters);
                    }
                } catch (Exception e) {
                    System.out.println("在创建对象时抛出异常，下面执行setAccessible()方法");
                    constructor.setAccessible(true);//设为允许访问
                }
            }

            if(example2 != null){
                example2.print();
                System.out.println();
            }
        }
    }

    public static void field_Test(){
        Example_02 example = new Example_02();
        Class exampleC = example.getClass();

        //获得所有的成员变量
        Field[] declaredFields = exampleC.getDeclaredFields();
        //获得成员变量名称
        for(int i = 0; i < declaredFields.length; i++){
            Field field = declaredFields[i];
            System.out.println("名称为： " + field.getName());
            Class fieldType = field.getType();
            System.out.println("类型为： " + fieldType);
            boolean isTurn = true;
            while(isTurn){
                //如果该成员变量的访问权限为private， 则抛出异常，即不允许访问
                try{
                    isTurn = false;
                    //获得成员变量值
                    System.out.println("修改前的值为： " + field.get(example));
                    //判断成员变量的值是否为int型
                    if(fieldType.equals(int.class)){
                        System.out.println("利用setInt()方法修改成员变量的值");
                        field.setInt(example, 168);
                    }else if(fieldType.equals(float.class)){
                        System.out.println("利用setFloat()方法修改成员变量的值");
                        field.setFloat(example, 99.9F);
                    }else if(fieldType.equals(boolean.class)){
                        System.out.println("利用setBoolean()方法修改成员变量的值");
                        field.setBoolean(example, true);
                    }else{
                        System.out.println("利用set()方法修改成员变量的值");
                        //set()方法可以为各种类型的成员变量赋值
                        field.set(example, "MWQ");
                    }
                    //获得成员变量的值
                    System.out.println("修改后的值为： " + field.get(example));
                }catch (Exception e){
                    System.out.println("在设置成员变量值时抛出异常，下面执行setAccessible()方法");
                    field.setAccessible(true);//设置为允许访问
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }

    public static void method_Test(){
        Example_03 example = new Example_03();
        Class exampleC = example.getClass();
        Method[] declaredMethods = exampleC.getDeclaredMethods();
        for(int i = 0; i < declaredMethods.length; i++){
            Method method = declaredMethods[i];
            System.out.println("名称为： " + method.getName());
            System.out.println("是否允许带有可变数量的参数： " + method.isVarArgs());
            System.out.println("入口参数类型依次为： ");
            //获得所有参数类型
            Class[] parameterTypes = method.getParameterTypes();
            for(int j = 0; j < parameterTypes.length; j++){
                System.out.println(" " + parameterTypes[j]);
            }
            //获得方法返回值类型
            System.out.println("返回值类型为： " +method.getReturnType());
            System.out.println("可能抛出的异常类型为： ");
            Class[] exceptionTypes = method.getExceptionTypes();
            for(int j = 0; j < exceptionTypes.length; j++){
                System.out.println(" " + exceptionTypes[j]);
            }
            boolean isTurn = true;
            while (isTurn){
                try {
                    isTurn = false;
                    if("staticMethod".equals(method.getName())){
                        //执行没有入口参数的方法
                        method.invoke(example);
                    }else if("publicMethod".equals(method.getName())){
                        //执行方法
                        method.invoke(example, 168);
                    }else if("protectedMethod".equals(method.getName())){
                        //执行方法
                        method.invoke(example, "7", 5);
                    }else if("privateMethod".equals(method.getName())){
                        //定义二维数组
                        Object[] parameters = new Object[]{new String[]{"M", "W", "Q"}};
                        System.out.println("返回值为：" + method.invoke(example, parameters));
                    }
                }catch (Exception e){
                    System.out.println("在执行方法时抛出异常，下面执行setAccessible()方法");
                    method.setAccessible(true);
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        method_Test();
    }
}
