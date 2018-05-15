package com.lhz;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * 实现用户输入用户名和密码，将每一个姓名和密码加在文件中，如果用户输入done就结束
 *
 * */
public class Exercise2 {
    private static File file = new File("D:\\SVN\\MyWork\\trunk\\IdeaProjects\\IOTest\\", "test.txt");

    //判断文件是否存在
    public static void exist_File() {
        if (file.exists()) {
            System.out.println("文件已经存在");
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void function() {
        String name = "";
        String password = "";
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            Scanner scanner = new Scanner(System.in);

            while (true){
                name = scanner.next();
                //判断用户输入的是否为done
                if(name.equals("done")) break;
                password = scanner.next();
                //判断用户输入的是否为done
                if(password.equals("done")) break;
                //写入用户名和密码
                bfw.write("用户名： " + name + "\t");
                bfw.write("密码： " + password);
                //换行
                bfw.newLine();
            }
            bfw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exist_File();
        function();
    }
}
