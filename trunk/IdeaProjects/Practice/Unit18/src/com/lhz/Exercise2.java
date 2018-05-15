package com.lhz;

/**
 * 设计四个线程对象，两个线程执行减操作，两个线程执行加操作。
 */
public class Exercise2 implements Runnable {

    boolean flag;
    int num;
    String threadName;

    Exercise2(int num, boolean flag, String threadName) {
        this.num = num;
        this.flag = flag;
        this.threadName = threadName;
    }

    public void doPlus() {
        while (num < 20) {
            System.out.println(threadName + "\tnum: " + num);
            try {
                Thread.sleep(500);
                num++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void doMiuns() {
        while (num > 0) {
            System.out.println(threadName + "\tnum: " + num);
            try {
                Thread.sleep(1000);
                num--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        //synchronized ("") {
            if (flag) {
                doPlus();
            } else {
                doMiuns();
            }
        //}
    }

    public static void main(String[] args) {
        Thread thread_a = new Thread(new Exercise2(10, true, "thread_a"));
        Thread thread_b = new Thread(new Exercise2(15, false, "thread_b"));
        Thread thread_c = new Thread(new Exercise2(20, false, "thread_c"));
        Thread thread_d = new Thread(new Exercise2(5, true, "thread_d"));

        thread_a.start();
        thread_b.start();
        thread_c.start();
        thread_d.start();
    }
}
