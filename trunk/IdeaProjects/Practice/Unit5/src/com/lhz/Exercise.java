package com.lhz;

// 通过toUpperCase()和toLowerCast()实现大小写转换
//截取字符串str1 str2中的部分内容，如果截取后的两个子串相同，会输出“两个子串相同”，否则输出“两个子串并不相同”
//使用正则表达式来判断字符串text是否为合法的手机号
//使用字符串生成器，将字符串str追加1~10这10个数字
public class Exercise {

    public static void main(String[] args){
        Exercise1();
        Exercise2();
        Exercise3();
        Exercise4();
    }

    // 通过toUpperCase()和toLowerCast()实现大小写转换
    private static void Exercise1(){
        System.out.println("---------练习1-----------");
        String str = "abcABC";

        System.out.println("原字符串str为:" + str);

        System.out.println("执行toUpperCase()后结果：" + str.toUpperCase());

        System.out.println("执行toLowerCase()后结果：" + str.toLowerCase());
    }


    //截取字符串str1 str2中的部分内容，如果截取后的两个子串相同（不区分大小写），会输出“两个子串相同”，否则输出“两个子串并不相同”
    private static void Exercise2(){
        System.out.println("---------练习2-----------");
        String str1 = "abcABC";
        String str2 = "ABCabc";
        System.out.println("原字符串 str1 = " + str1 + "\tstr2 = " + str2);
        //题目要求忽视大小写问题，截取字符串后使用equalsIgnoreCase进行比较
        String str1_sub = str1.substring(0, 3);
        String str2_sub = str2.substring(0, 3);
        String str2_sub2 = str2.substring(2, 5);
        System.out.println("子串str1_sub = " + str1_sub);
        System.out.println("子串str2_sub = " + str2_sub);
        System.out.println("子串str2_sub2 = " + str2_sub2);
        System.out.println("比较子串str1_sub和子串str2_sub");
        if(str1_sub.equalsIgnoreCase(str2_sub)){
            System.out.println("两个子串相同");
        }else{
            System.out.println("两个子串并不相同");
        }

        System.out.println("比较子串str1_sub和子串str2_sub2");
        if(str1_sub.equalsIgnoreCase(str2_sub2)){
            System.out.println("两个子串相同");
        }else{
            System.out.println("两个子串并不相同");
        }

    }

    //使用正则表达式来判断字符串text是否为合法的手机号
    private static void Exercise3(){
        System.out.println("---------练习3-----------");
        //1[3-5|8-9] 意思是1开头，第二位是3，4，5或8，9
        //\\d{9} 意思是 \\d指代0~9任意数字 {9}一共9位
        String regex = "(1[3-5|8-9])\\d{9}$";
        String phone1 = "18202738039";
        String phone2 = "23547895478";
        String phone3 = "18247878";
        System.out.println(phone1.matches(regex));
        System.out.println(phone2.matches(regex));
        System.out.println(phone3.matches(regex));

    }

    //使用字符串生成器，将字符串str追加1~10这10个数字
    private static void Exercise4(){
        System.out.println("---------练习4-----------");
        String str = "空";
        System.out.println("str字符串默认为：" + str);
        StringBuilder builder = new StringBuilder();
        for(int i = 1; i < 11; i++){
            builder.append(i);
        }
        str += builder.toString();
        System.out.println("str通过字符串生成器生成后的结果为:" + str);
        /*long starTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            str += i ;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - starTime;
        System.out.println("String消耗时间:" + time);
        StringBuilder builder = new StringBuilder();
        starTime = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            builder.append(i);
        }
        endTime = System.currentTimeMillis();
        time = endTime - starTime;
        System.out.println("StringBuilder消耗时间:" + time);*/
    }
}
