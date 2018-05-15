package com.lhz;

import java.lang.reflect.Array;

/**
 * 利用反射实现扩展数组长度的方法
 */
public class Exercise1 {

    public static void main(String[] args){
        int[] intArray = {1, 2, 3, 4, 5};
        int[] newIntArray = (int[]) changeArraySize(intArray, 10);

        print(newIntArray);

    }

    /**
     * 扩展数组长度方法
     * @param obj Object 数组对象
     * @param len 需要扩展的长度
     * @return 返回扩展长度后的数组对象
     */
    private static Object changeArraySize(Object obj, int len){
        Class<?> arr = obj.getClass().getComponentType();
        Object newArray = Array.newInstance(arr, len);

        //拷贝数组
        int length = Array.getLength(obj);
        System.arraycopy(obj, 0, newArray, 0, length);
        return newArray;
    }

    /**
     * 打印数组方法
     * @param obj 传入 Object 对象（数组）
     */
    private static void print(Object obj){
        Class<?> c = obj.getClass();
        if(!c.isArray()){
            return;
        }

        System.out.println("\nArray长度为： " + Array.getLength(obj));

        for(int i = 0; i < Array.getLength(obj); i++){
            System.out.println(Array.get(obj, i) + " ");
        }
    }
}
