package com.lhz;

interface Exercise1_Test {
    int getValue();
}

public class Exercise1 {

    private Exercise1_Test doit() {
        return new Exercise1_Test() {
            private int i = 10;

            public int getValue() {
                return i;
            }
        };
    }


    public static void main(String[] args0){
        Exercise1_Test et = new Exercise1().doit();
        System.out.println(et.getValue());

        new Object(){
            void show(){
                System.out.println("My_Test.show()");
            }
        }.show();
    }
}
