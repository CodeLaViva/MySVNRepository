package com.lhz;

import java.util.*;

public class Exercise implements Comparable<Object> {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String name;
    long id;

    Exercise(String name, int id) {
        this.name = name;
        this.id = id;
    }

    //存入TreeSet类实现的Set集合必须实现Comparable接口，该接口中的compareTo(Object o)方法比较此对象与指定对象的顺序
    @Override
    public int compareTo(Object o) {
        Exercise ex = (Exercise) o;
        //int result = id > ex.id ? 1 : (id == ex.id ? 0 : -1);
        //可以被 compare方法替代
        int result = Long.compare(id, ex.id);
        return result;
    }

    public static void HashMap_Test(){
        Map<String, Long> map = new HashMap<>();
        Exercise ex1 = new Exercise("李1", 1001);
        Exercise ex2 = new Exercise("李2", 1002);
        Exercise ex3 = new Exercise("李3", 1003);
        Exercise ex4 = new Exercise("李4", 1004);
        Exercise ex5 = new Exercise("李5", 1005);

        map.put(ex1.getName(), ex1.getId());
        map.put(ex2.getName(), ex2.getId());
        map.put(ex3.getName(), ex3.getId());
        map.put(ex4.getName(), ex4.getId());
        map.put(ex5.getName(), ex5.getId());

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        System.out.println("HashMap类实现的Map集合，无序：");
        while (it.hasNext()){
            String name = it.next();
            long id = map.get(name);
            System.out.println(id + " " + name);
        }
        TreeMap<String, Long> treemap = new TreeMap<>();
        treemap.putAll(map);
        Iterator<String> iter = treemap.keySet().iterator();
        System.out.println("TreeMap 类实现的Map集合， 键对象升序");
        while (iter.hasNext()){
            String name = iter.next();
            long id = treemap.get(name);
            System.out.println(id + " " + name);
        }
    }

    public static void Map_Test() {
        Map<String, String> map = new HashMap<>();
        map.put("01", "李1");
        map.put("02", "李2");
        map.put("03", "李3");
        map.put("04", "李4");
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        System.out.println("key集合中的元素：");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        Collection<String> coll = map.values();
        it = coll.iterator();
        System.out.println("values集合中的元素： ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void TreeSet_Test() {
        Exercise ex1 = new Exercise("李", 1001);
        Exercise ex2 = new Exercise("陈", 1002);
        Exercise ex3 = new Exercise("王", 1003);
        Exercise ex4 = new Exercise("赵", 1004);
        TreeSet<Exercise> tree = new TreeSet<>();
        tree.add(ex1);
        tree.add(ex2);
        tree.add(ex3);
        tree.add(ex4);
        Iterator<Exercise> it = tree.iterator();
        System.out.println("TreeSet合集中的所有数据：");
        while (it.hasNext()) {
            Exercise ex = it.next();
            System.out.println(ex.getId() + " " + ex.getName());
        }
        it = tree.headSet(ex4).iterator();
        System.out.println("截取前面部分的集合：");
        while (it.hasNext()) {
            Exercise ex = it.next();
            System.out.println(ex.getId() + " " + ex.getName());
        }
        it = tree.subSet(ex1, ex3).iterator();
        System.out.println("截取中间部分的集合：");
        while (it.hasNext()) {
            Exercise ex = it.next();
            System.out.println(ex.getId() + " " + ex.getName());
        }
        it = tree.tailSet(ex2).iterator();
        System.out.println("截取后面部分的集合：");
        while (it.hasNext()) {
            Exercise ex = it.next();
            System.out.println(ex.getId() + " " + ex.getName());
        }
        System.out.println(ex1.compareTo(ex2));
    }

    public static void List_Test() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        int i = (int) (Math.random() * list.size());
        System.out.println("随机获取的元素为第" + (i + 1) + "个，值为： " + list.get(i));
        list.remove(2);
        for (int j = 0; j < list.size(); j++) {
            System.out.println(list.get(j));
        }
    }

    public static void Collection_Test() {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.remove("c");
        System.out.println(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        HashMap_Test();
    }
}
