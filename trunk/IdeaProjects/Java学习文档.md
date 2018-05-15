# 学习汇总文档

> ___目录：___
- [1.第一章 Java简介：](#1-java)
- [2.第三章 Java语言基础：](#2-java)
- [3.第四章 流程控制：](#3)
- [4.第五章 字符串：](#4)
- [5.第六章 数组：](#5)
- [6.第七章 类和对象：](#6)
- [7.第八章 包装类：](#7)
- [8.第九章 数字处理类：](#8)
- [9.第十章 接口继承和多态：](#9)
- [10.第十一章 Java类包：](#10-java)
- [11.第十二章 异常处理：](#11)
- [12.第十四章 集合类：](#12)
- [13.第十五章 I/O：](#13-i-o)
- [14.第十六章 反射：](#14)
- [15.第十七章 枚举类型与泛型：](#15)
- [16.第十八章 多线程：](#16)
- [17.第十九章 网络通信：](#17)
- [18.第二十章 数据库操作：](#18)

## 章节报告

### 1.第一章 Java简介：

本章主要学习了Java语言特性、环境搭建。

### 2.第三章 Java语言基础：

本章主要学习了Java语言基本类型、关键字等。

### 3.第四章 流程控制：

本章主要学习了Java语言的各种循环控制。

### 4.第五章 字符串：

本章主要学习了Java语言的字符串类型。

可以使用格式化操作 `format` 对字符串进行格式化

可以通过字符串构造器`StringBuilder`便捷创建字长符串

### 5.第六章 数组：

本章主要学习了Java语言的数组类型， 学习数组的操作方法、排序以及二维数组的操作等。

### 6.第七章 类和对象：

本章主要学习了Java语言的类和对象的操作

Java 语言面向对象的表现就体现在 封装、继承、多态、抽象

学习Java 关于 static变量、 final变量 的内存关系

### 7.第八章 包装类：

本章主要学习了Java语言的几个基础包装类的应用。

包装类在使用时需要进行实例化，Integer是对象，用一个引用指向这个对象；而int是基本类型，直接存储数值。

### 8.第九章 数字处理类：

本章主要学习了Java的 Math类、 Random类等用于处理数字的工具类。

### 9.第十章 接口继承和多态：

本章学习了Java的核心之一， 接口、继承、多态

下面这个实例展示了多态的表现，核心的抽象类Animal 只有一个 eat方法， Cat类和 Dog类都继承于 Animal类并且实现了抽象方法，且各自添加了 work方法。在执行 show方法的是时候， show 方法的参数为 Animal类型，调用 eat方法时会自动对 传入的Animal参数进行判定， 如果是 Cat 就调用 Cat的 eat方法

```java
abstract class Animal {
        abstract void eat();
    }

    class Cat extends Animal {
        public void eat() {
            System.out.println("吃鱼");
        }

        public void work() {
            System.out.println("抓老鼠");
        }
    }

    class Dog extends Animal {
        public void eat() {
            System.out.println("吃骨头");
        }

        public void work() {
            System.out.println("看家");
        }
    }

    public static void main(String[] args) {
        Duotai_test test = new Duotai_test();
        test.mytest();
    }

    private void mytest(){
        show(new Cat());  // 以 Cat 对象调用 show 方法
        show(new Dog());  // 以 Dog 对象调用 show 方法
        Animal a = new Cat();  // 向上转型
        a.eat();               // 调用的是 Cat 的 eat
        Cat c = (Cat) a;        // 向下转型
        c.work();        // 调用的是 Cat 的 work
    }

    private static void show(Animal a) {
        a.eat();
        // 类型判断
        if (a instanceof Cat) {  // 猫做的事情
            Cat c = (Cat) a;
            c.work();
        } else if (a instanceof Dog) { // 狗做的事情
            Dog c = (Dog) a;
            c.work();
        }
    }
```

### 10.第十一章 Java类包：

  * 为什么需要内部类

    1. 内部类对象可以访问创建它的对象的实现，包括私有数据；
    2. 内部类不为同一包的其他类所见，具有很好的封装性；
    3. 使用内部类可以很方便的编写事件驱动程序；
    4. 匿名内部类可以方便的定义运行时回调；
    5. 内部类可以方便的定义

  * 成员内部类

    1. 作为外部类的一个成员存在，与外部类的属性、方法并列。
    1. 成员内部类也是定义在另一个类中，但是定义时不用static修饰。
    1. 成员内部类和静态内部类可以类比为非静态的成员变量和静态的成员变量。
    1. 成员内部类就像一个实例变量。
    1. 它可以访问它的外部类的所有成员变量和方法，不管是静态的还是非静态的都可以。

  * 匿名内部类

    1. 匿名内部类不能有构造方法。
    1. 匿名内部类不能定义任何静态成员、方法和类。
    1. 匿名内部类不能是public,protected,private,static。
    1. 只能创建匿名内部类的一个实例。
    1. 一个匿名内部类一定是在new的后面，用其隐含实现一个接口或实现一个类。
    1. 因匿名内部类为局部内部类，所以局部内部类的所有限制都对其生效。

学习疑问

抽象类中，在抽象类的构造方法里调用了抽象方法，如果子类实例化过，会调用子类实例化后的方法？

```java
abstract test{
    test(){
        function();
    }

    abstract void function();

    public static void main(String[] args){
        test test = new test();
    }
}

public class my_test extends test{
    my_test(){

    }

    public void function(){
        System.out.println("我是继承类");
    }
}
```

### 11.第十二章 异常处理：

本章主要学习了Java关于异常类的相关内容

学习了自定义异常类进行异常抛出操作

### 12.第十四章 集合类：

本章主要学习了Java 各种集合类的操作方法、特性

hibernate 在全注解方式实现数据库操作中使用了 TreeMap 作为参数的 map集合，但是会造成参数自动排序的问题，导致最后创建的数据库会有列混乱的现象，需要手动修改成 LinkedHashMap 这样就能解决这个问题。

### 13.第十五章 I/O：

本章主要学习了Java 的输入输出操作，以及文件操作相关， 可以通过程序对 File 进行相关的操作。

学习了InputStream InputStreamBuffer BufferedOutputStream等类各自的使用方法以及各自之间的不同之处

### 14.第十六章 反射：

本章主要学习了Java 的一个核心机制， 反射。反射机制的优点就是可以实现动态创建对象和编译，体现出很大的灵活性。缺点是对性能有影响。使用反射基本上是一种解释操作，可以告诉JVM，我们希望做什么并且满足要求。这类操作总是慢于直接执行相同的操作。

反射机制使用实例

```java
        //泛型的作用是在编译阶段防止错误输入，绕过编译就绕过了泛型
        //反射都是绕过编译操作
        ArrayList<String> str = new ArrayList<String>();
        str.add("你好！");
        ArrayList str2 = new ArrayList();

        //结果是true说明类类型是一样的，编译后是去泛型化的
        System.out.println(str.getClass() == str2.getClass());
        System.out.println(str.getClass() == ArrayList.class);

        //用add方法的反射
        try {
            Method method = str.getClass().getMethod("add", new Class[]{Object.class});
            method.invoke(str, new Object[]{100});
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(str.size());
        System.out.println(str);

        for (String s : str) {
            System.out.println(s);
        }
```

第16章 习题第二题（使用反射初步验证用户输入信息）没有实现出来

### 15.第十七章 枚举类型与泛型：

本章主要学习了Java 中的枚举类型和泛型的相关知识

泛型实例

```java
/**
* Exercise1类使用泛型 T 限定 List
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
        Exercise1<ArrayList> ex1 = new Exercise1<ArrayList>(arrayList);

        //Exercise1<HashMap> ex2 = new Exercise1<HashMap>();
        //会报错，因为 HashMap 并没有使用 List 接口

        //使用通配符实现
        Exercise1<? extends List> ex2_ = new Exercise1<>(arrayList);
        Class<?> ex2_C = ex2_.getClass();
        ArrayList array = (ArrayList) Array.newInstance(Integer.class, 10);
        LinkedList linkedList = (LinkedList) Array.newInstance(String.class, 5);
        System.out.println(ex2_C.getName());
    }
```

泛型和枚举大大降低了程序在实现过程中的一些重复操作，使用泛型能够减少类的转换，提高程序的可读性

### 16.第十八章 多线程：

本章主要学习了Java 的多线程相关知识， 学习了两种实现多线程的方式 extends Thread 和 implement Runnable

更推荐使用Runnable接口实现多线程，实现 Runnable接口相对于继承 Thread类来说，有如下的显著优势：

   1. 适合多个相同代码的线程去处理同一个资源的情况
   2. 可以避免由于 java的单继承特性带来的局限
   3. 增强了程序的健壮性，代码能够被多个线程共享，代码与数据时独立的

问题： 调用 Thread.start()时，可能是同时会调用两个，在测试时，同时编写了

    ```java
    Class thread_Test implement Runnable {......}

    public static void main(String[] args){
        thread_Test threadA = new thread_Test(10, "ThreadA");
        thread_Test threadB = new thread_Test(10, "threadB");
        thread_Test threadC = new thread_Test(10, "threadC");
        thread_Test threadD = new thread_Test(10, "threadD");

        threadA.setPriority(Thread.MIN_PRIORITY);
        threadB.setPriority(Thread.NORM_PRIORITY);
        threadC.setPriority(Thread.NORM_PRIORITY + 1);
        threadD.setPriority(Thread.MAX_PRIORITY);

        threadA.start();
        threadD.start();
        threadB.start();
        threadC.start();
    }
    ```
测试时，发现给D设置了最高优先级后，每次运行，都会先调用 D而不是 A。

### 17.第十九章 网络通信：

本章主要学习了Java 中的 TCP通信和 UDP广播相关内容

TCP 简单连接实例

client端

```java
    private Socket socket;
    private static final int port = 8001;
    private static final String host = "127.0.0.1";

    //连接客户端
    private void connect() {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exercise2_Client connect = new Exercise2_Client();
        connect.connect();
    }
```

server端

```java
    private ServerSocket ss;
    private Socket socket;

    private static final int port = 8001;

    //创建连接接口，等待客户端进行连接
    public void getServer() {
        try {
            ss = new ServerSocket(port);
            socket = ss.accept();

            System.out.println("New connection accepted " +
                    socket.getInetAddress() + ":" + socket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exercise2_Server test = new Exercise2_Server();
        test.getServer();
    }
```

### 18.第二十章 数据库操作：

本章主要学习了Java中 通过 JDBC 对数据库进行操作

jdbc连接数据库的标准操作（需要导入相关数据库的驱动包， 这里测试的是 PostgreSQL）

```java
        Connection conn = null;
        try {
            //连接数据库 通过反射的方式
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
```
