package com.lhz;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 定义一个泛型类， 使用extends 限制类型为List接口， 并分别创建两个泛型对象
 * @param <T>
 */
public class Exercise1<T extends List> {

    private T arrayList;

    private Exercise1(T list){
        this.arrayList = list;
    }

    public void setList(int... num){
        for(int i = 0; i < num.length; i++){
            arrayList.add(num[i]);
        }
    }

    public T getList(){
        return arrayList;
    }

    public void printList(){
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i) + "");
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        Exercise1<ArrayList> ex1 = new Exercise1<ArrayList>(arrayList);
        //ex1.printList();
        //ex1.setList(5,4,3,2,1);
        //ex1.printList();
        //Exercise1<LinkedList> ex2 = new Exercise1<LinkedList>();
        //Exercise1<HashMap> ex3 = new Exercise1<HashMap>();

        //使用通配符实现
        Exercise1<? extends List> ex2_ = new Exercise1<>(arrayList);
        Class<?> ex2_C = ex2_.getClass();
        ArrayList array = (ArrayList) Array.newInstance(Integer.class, 10);
        LinkedList linkedList = (LinkedList) Array.newInstance(String.class, 5);
        System.out.println(ex2_C.getName());
    }
}


