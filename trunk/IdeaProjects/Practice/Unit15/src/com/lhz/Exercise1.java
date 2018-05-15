package com.lhz;

import java.io.*;
import java.util.Scanner;

/**
 * 编写程序，使用字符输入输出流读取文件，将文字加密后，再写入文件，再读取加密后文件，并且打印
 */

public class Exercise1 {
    private static File file = new File("D:\\SVN\\MyWork\\trunk\\IdeaProjects\\IOTest\\", "test.txt");

    //判断文件是否存在
    public static void exist_File() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
                //字符流输入FileWriter对象
                FileWriter fw = new FileWriter(file);
                String str = "this is my test string.";
                //字符流输入
                fw.write(str);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("文件已经存在");
        }
    }

    public static void function() {
        String str;
        char char_reader[];
        int len;

        try {

            //字符流输出FileReader对象
            FileReader fr = new FileReader(file);
            Scanner scanner = new Scanner(System.in);


            //字符流输出
            char_reader = new char[1024];
            len = fr.read(char_reader);
            str = new String(char_reader, 0, len);
            System.out.println("文件里的原内容是: " + str);
            fr.close();

            //加密
            str = deal(str, (byte) 88);

            //字符流输入FileWriter对象
            FileWriter fw = new FileWriter(file);
            //字符流输入
            fw.write(str);
            fw.close();

            fr = new FileReader(file);
            //字符流输出
            char_reader = new char[1024];
            len = fr.read(char_reader);
            str = new String(char_reader, 0, len);
            System.out.println("文件里的加密后的内容是: " + str);
            fr.close();

            //解密
            str = deal(str, (byte) 88);
            System.out.println("解密后的字符串为： " + str);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 简单加密加密解密字符串
     * 加密解密思路：先将字符串变成byte数组，再将数组每位与key做位运算，得到新的数组就是加密或解密后的byte数组.
     * 知识：^ 是java位运算，可以百度了解下，a = b ^ skey 反之也成立，即b = a ^ skey
     * @param str 解密/加密 字符串
     * @param key  解密/加密 密钥（加密解密为同一个密钥才能解密，否则是乱码）
     * @return
     * @throws Exception
     */
    static String deal(String str, byte key) throws Exception {
        byte[] bytes = str.getBytes("GBK");

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ key);
        }

        return new String(bytes, "GBK");
    }


    public static void main(String[] args) throws Exception {
        exist_File();
        function();

    }
}
