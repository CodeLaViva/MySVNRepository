package com.lhz;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 从键盘输入文件的内容和要保存的文件名称，之后根据输入的名称创建文件，并将内容保存到文件之中。
 */

public class Exercise2 {

    public static File createFile(String fileName) {
        //获取文件路径
        File file = new File("D:\\SVN\\MyWork\\trunk\\IdeaProjects\\IOTest\\", fileName + ".txt");
        try {
            if (file.exists()) {
                System.out.println("文件已经存在");
                return file;
            } else {

                file.createNewFile();
                System.out.println("文件创建成功");
                return file;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //写入Content信息
    public static void fileWriter(String fileContent, File file) {
        //字符流输入FileWriter对象
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(fileContent);
            System.out.println("Content 写入成功");
            fw.close();
        } catch (IOException e) {
            System.out.println("Content 写入失败");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要保存的文件名称： ");
        String fileName = scanner.next();
        scanner.nextLine();
        File file = createFile(fileName);


        System.out.println("请输入需要保存的文件内容： ");

        String fileContent = scanner.nextLine();
        fileWriter(fileContent, file);
        try {
            //打开文件
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
