package com.lhz;

public class Exercise1 extends Thread {
    private int flag;

    Exercise1(int flag){
        this.flag = flag;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0; i < flag; i++){
            System.out.println("我是第" + i + "句话");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args){
        Exercise1 ex1 = new Exercise1(5);
        ex1.start();
    }
}
