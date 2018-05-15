package com.lhz;

import java.io.*;

public class Test {

    public static void File_Test(){
        File file = new File("D:\\test\\","word.txt");
        if(file.exists()){
            String file_name = file.getName();
            long length = file.length();
            boolean hidden = file.isHidden();
            String absolutePath = file.getAbsolutePath();
            System.out.println("文件名称： " + file_name);
            System.out.println("文件地址： " + absolutePath);
            System.out.println("文件长度： " + length);
            System.out.println("文件是否隐藏： " + hidden);
            //file.delete();
            //System.out.println("文件已被删除");
        }
        else{
            try {
                file.createNewFile();
                System.out.println("文件已被创建");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字符流输入
    private static void File_Set(File file){
        //File file = new File("D:\\test\\","word.txt");
        if(file.exists()){
            try {
                //创建FileOutputStream对象
                FileOutputStream out = new FileOutputStream(file);
                //创建byte型数组
                byte[] my_byte = "你快乐吗？我很快乐！".getBytes();
                out.write(my_byte);
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            System.out.println("文件不存在");
        }
    }

    //字符流输出
    private static void File_Get(File file){
        if(file.exists()){
            try {
                FileInputStream in = new FileInputStream(file);
                byte[] my_byte = new byte[1024];
                int len = in.read(my_byte);
                System.out.println("文件中的内容是： " + new String(my_byte, 0, len));
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //字节流输入
    private static void FileWriter_Set(File file){
        try {
            FileWriter fw = new FileWriter(file);
            String xinxi = "这是字节流输出方法里进行输入的信息！";
            fw.write(xinxi);
            fw.close();

        } catch (IOException e) {

        }
    }

    //字节流输入
    private static void FileRead_Set(File file){
        try {
            FileReader fr = new FileReader(file);
            char xinxi[] = new char[1024];
            int len = fr.read(xinxi);
            System.out.println("文件里的内容是: " + new String(xinxi, 0, len));
            fr.close();

        } catch (IOException e) {

        }
    }

    private static void BufferedWriter_Test(File file){
        String content[] = {"好久不见", "你还好吗", "常联系"};
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bfw = new BufferedWriter(fw);
            for (String aContent : content) {
                bfw.write(aContent);
                bfw.newLine();
            }
            bfw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void BufferedReader_Test(File file){
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            //如果文件的文本行数不为null，进行循环
            while ((s = bfr.readLine()) != null){
                i++;
                System.out.println("第" + i + "行：" + s);
            }
            bfr.close();
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        //File file = new File("D:\\test\\","word.txt");
        File file = new File("D:\\SVN\\MyWork\\trunk\\IdeaProjects\\IOTest\\", "test.txt");
        //BufferedWriter_Test(file);
        //BufferedReader_Test(file);
        FileRead_Set(file);
    }
}
