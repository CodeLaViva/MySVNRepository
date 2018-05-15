package com.lhz;

interface d {
    public String getDescription();

    public String get();
}

public enum MyConstants implements d {
    Constant_A {
        @Override
        public String getDescription() {
            return "我是A";
        }

        @Override
        public String get() {
            return "A";
        }
    },

    Constant_B {
        @Override
        public String getDescription() {
            return "我是B";
        }

        @Override
        public String get() {
            return "B";
        }
    },

    Constant_C {
        @Override
        public String getDescription() {
            return "我是C";
        }

        @Override
        public String get() {
            return "C";
        }
    };

    public static void main(String[] args){
        System.out.println(MyConstants.Constant_A.get());
        System.out.println(Constant_A.ordinal());
        System.out.println(MyConstants.values()[1]);
    }

}
