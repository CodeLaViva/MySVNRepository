package com.lhz.example;

public class Example_01 {
    String s;
    int i1, i2, i3;

    private Example_01(){

    }

    protected Example_01(String s, int i1){
        this.s = s;
        this.i1 = i1;
    }

    public Example_01(String... strings)throws NumberFormatException {
        if(0 < strings.length)
            i1 = Integer.valueOf(strings[0]);
        if(1 < strings.length)
            i2 = Integer.valueOf(strings[1]);
        if(2 < strings.length)
            i3 = Integer.valueOf(strings[2]);
    }

    public void print(){
        System.out.println("s = " + s);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
