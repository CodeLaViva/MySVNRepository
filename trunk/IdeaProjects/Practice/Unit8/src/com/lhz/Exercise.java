package com.lhz;

public class Exercise {
    public static void main(String[] args){
        //System.out.println(Exercise1() + " ");
        //Exercise2();
        Exercise3();

    }

    //创建Integer对象，并以int类型返回
    private static int Exercise1(){
        System.out.println("---------练习1-----------");
        Integer integer = new Integer(5);
        return integer;
    }

    //创建两个Character对象，比较 == 和equals 转成小写后再进行比较，分析结果
    private static void Exercise2(){
        System.out.println("---------练习2-----------");
        //如果使用Character c1 = 'A'; 是无法创建对象的 要用new关键字
        Character c1 = new Character('A');
        Character c2 = new Character('A');
        System.out.println("c1: " + c1 + " c2: " + c2);
        //由于现在是两个对象，所以 == 返回false
        System.out.println("c1 == c2 ? " + (c1 == c2));
        System.out.println("c1 equals c2 ? " + (c1.equals(c2)));
        //大小写转换后 直接调用常量池 所以此时 == 是返回true的
        c1 = Character.toLowerCase(c1);
        c2 = Character.toLowerCase(c2);
        System.out.println("c1: " + c1 + " c2: " + c2);
        System.out.println("c1 == c2 ? " + (c1 == c2));
        System.out.println("c1 equals c2 ? " + (c1.equals(c2)));
    }

    //通过字符型变量创建boolean值，将其转换成字符串输出，观察输出后的字符串与创建boolean对象的给定参数是否相同
    private static void Exercise3(){
        System.out.println("---------练习3-----------");
        String t = "false";
        Boolean b = new Boolean(t);
        System.out.println(t.equals(b.toString()));
        String t1 = "true";
        Boolean b1 = new Boolean(t);
        System.out.println(t.equals(b.toString()));

    }
}
