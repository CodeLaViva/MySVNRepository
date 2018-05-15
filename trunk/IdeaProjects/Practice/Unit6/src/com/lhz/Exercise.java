package com.lhz;

import java.util.Arrays;

//将数组arr1中 索引0-3的元素复制到数组arr2 并且输出
//输出数组中最小的数
//将arr中索引 2的元素替换成bb，并将原数组和新数组输出
//将二维数组的行列互调显示
public class Exercise {

    public static void main(String[] args){
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();

    }

    //将数组arr1中 索引0-3的元素复制到数组arr2 并且输出
    private static void Exercise1(){
        System.out.println("---------练习1-----------");
        int[] arr1 = {0, 1, 2, 3, 4, 5};
        int[] arr2 ;
        System.out.println("原数组arr1为： ");
        for(int x : arr1){
            System.out.print(x + "\t");
        }
        System.out.println("");
        //copyOfRange (arr, int fromIndex, toIndex)
        //fromIndex 是开始位置，复制时包括该索引元素
        //toIndex是结束位置， 复制时不包括该索引元素
        //要求复制0-3的索引元素，所以复制起始位置为0， 结束位置为4
        arr2 = Arrays.copyOfRange(arr1, 0, 4);
        System.out.println("新数组arr2为： ");
        for(int x : arr2){
            System.out.print(x + "\t");
        }
        System.out.println("");
    }

    //输出数组中最小的数
    private static void Exercise2(){
        System.out.println("---------练习2-----------");
        int arr[] = {5, 7, 4, 2, 8, 9};

        //通过Arrays中的 sort排序方法，将数组先进行排序，然后输出0索引数就是最小值
        //最大值就是此时数组中最后一位索引的数值
        Arrays.sort(arr);
        int temp = arr.length;
        System.out.println("数组中最小的数为： " + arr[0]);
        System.out.println("数组中最大的数为： " + arr[temp-1]);
    }

    //将arr中索引 2的元素替换成bb，并将原数组和新数组输出
    private static void Exercise3(){
        System.out.println("---------练习3-----------");
        String[] arr =  {"132", "22", "aaa", "cc"};
        System.out.print("替换前的数组为： ");
        for (String x : arr){
            System.out.print(x + " ");
        }
        System.out.println("");
        //替换索引位置为2的元素，就是替换起始位置为2，结束位置为3的元素
        Arrays.fill(arr, 2, 3, "bb");
        System.out.print("替换后的数组为： ");
        for (String x : arr){
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    //将二维数组的行列互调显示
    private static void Exercise4(){
        System.out.println("---------练习4-----------");
        int[][] a = {{1,2,3,4},{5,6,7,8},{9,8,7,6},{5,4,3,2}};
        int i = 0, j = 0;
        System.out.println("正常显示二维数组为：");
        /*for(int[] x : a){
            i++;

            for(int y : x){
                j++;
                System.out.print(y + "\t");
                if(i == a.length && j == x.length){
                    break;
                }
            }
            System.out.println("");
        }*/
        for (int[] a1 : a) {
            for (int n = 0; n < a.length; n++) {
                System.out.print(a1[n] + "\t");
            }
            System.out.println("");
        }
        System.out.println("互调显示二维数组为：");
        for(int m = 0; m < a.length; m++){
            for (int[] a1 : a) {
                System.out.print(a1[m] + "\t");
            }
            System.out.println("");
        }


    }
}
