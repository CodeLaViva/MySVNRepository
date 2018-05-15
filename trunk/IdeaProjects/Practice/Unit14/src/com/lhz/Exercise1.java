package com.lhz;

import java.util.*;

public class Exercise1 {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String name;
    private String id;

    private Exercise1(String id, String name){
        this.id = id;
        this.name = name;
    }

    //将1~100所有正整数存在一个List集合中，并移除索引位置是10的对象
    private static void Exercise1_Test() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            list.add(i);
        }
        list.remove(10);

        for (Integer x : list) {
            System.out.println(x);
        }
    }

    //分别向Set和List集合中添加'A' 'a' 'c' 'C' 'a'五个元素，观察重复值'a'是否能在两个集合中添加
    private static void Exercise2_Test() {
        List<Character> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();

        list.add('A');
        list.add('a');
        list.add('c');
        list.add('C');
        list.add('a');

        set.add('A');
        set.add('a');
        set.add('c');
        set.add('C');
        set.add('a');

        Iterator<Character> it = set.iterator();

        //List能够添加重复值
        System.out.println("List集合：");
        for (char c : list) {
            System.out.println(" " + c);
        }

        //Set不能添加重复值
        System.out.println("Set集合：");
        while (it.hasNext()) {
            System.out.println(" " + it.next());
        }


    }

    //创建Map集合， 创建Exercise1对象，并将对象放到集合中，将id为“015”的对象从集合中移除
    private static void Exercise3_Test() {
        Map<String, String> map = new HashMap<>();

        Exercise1 ex1 = new Exercise1("011", "101李");
        Exercise1 ex2 = new Exercise1("012", "102李");
        Exercise1 ex3 = new Exercise1("013", "103李");
        Exercise1 ex4 = new Exercise1("014", "104李");
        Exercise1 ex5 = new Exercise1("015", "105李");

        map.put(ex1.getId(), ex1.getName());
        map.put(ex2.getId(), ex2.getName());
        map.put(ex3.getId(), ex3.getName());
        map.put(ex4.getId(), ex4.getName());
        map.put(ex5.getId(), ex5.getName());

        Iterator<String> it = map.keySet().iterator();
        System.out.println("移除前集合： ");
        while (it.hasNext()){
            String id = it.next();
            String name = map.get(id);
            System.out.println(id + " " + name);
        }

        map.remove("015");
        it = map.keySet().iterator();
        System.out.println("移除后集合： ");
        while (it.hasNext()){
            String id = it.next();
            String name = map.get(id);
            System.out.println(id + " " + name);
        }
    }

    public static void main(String[] args) {
        Exercise1_Test();
        Exercise2_Test();
        Exercise3_Test();
    }
}
