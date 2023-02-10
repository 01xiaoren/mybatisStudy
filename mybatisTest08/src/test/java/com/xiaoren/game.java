package com.xiaoren;
public class game {
    public static void main(String[] args) {
        new Son().doSome();
    }
}

//父亲
class Father {
    public void smoke() {
        System.out.println("抽点小烟");
    }
}

class Mother {
    void drink() {
        System.out.println("喝点小酒");
    }
}

class Son {
    class Inter1 extends Father { }

    class Inter2 extends Mother { }

    public void doSome() {
        this.new Inter1().smoke();
        this.new Inter2().drink();
    }
}
