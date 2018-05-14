# 5.7 第十二天日记

## 今天学习进度

* 将反射再次巩固一遍
* 学习Java第四版第18章 多线程（跟随视频进行相关的编程练习）
* 完成第18章课后习题（需要使用swing的题跳过）
* 泛型和枚举大大降低了程序在实现过程中的一些重复操作，使用泛型能够减少类的转换，提高程序的可读性

## 学习记录

* 更推荐使用Runnable接口实现多线程，实现Runnable接口相对于继承Thread类来说，有如下的显著优势：
   1. 适合多个相同代码的线程去处理同一个资源的情况
   2. 可以避免由于java的单继承特性带来的局限
   3. 增强了程序的健壮性，代码能够被多个线程共享，代码与数据时独立的
* 调用Thread.start()时，可能是同时会调用两个，在测试时，同时编写了

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
测试时，发现给D设置了最高优先级后，每次运行，都会先调用D而不是A。