package com.atguigu.接口隔离原则.改进;

/**
 * @author lhtao
 * @date 2020/3/19 11:16
 */
public class SegregationImprove {
    public static void main(String[] args) throws Exception {
        A a = new A();
        a.depend1(new C());
        a.depend2(new C());
        a.depend3(new C());
        B b = new B();
        b.depend1(new D());
        b.depend4(new D());
        b.depend5(new D());
    }
}

interface Interface1 {

    void operate1();
}

interface Interface2 {

    void operate2();
    void operate3();
}

interface Interface3 {

    void operate4();
    void operate5();
}

class C implements Interface1, Interface2 {

    @Override
    public void operate1() {
        System.out.println("C operate1");
    }

    @Override
    public void operate2() {
        System.out.println("C operate2");
    }

    @Override
    public void operate3() {
        System.out.println("C operate3");
    }
}

class D implements Interface1, Interface3 {

    @Override
    public void operate1() {
        System.out.println("D operate1");
    }

    @Override
    public void operate4() {
        System.out.println("D operate4");
    }

    @Override
    public void operate5() {
        System.out.println("D operate5");
    }
}

class A { //A 类通过接口Interface1 依赖(使用)B类，但是只会用到1，2，3方法

    public void depend1(Interface1 i){
        i.operate1();
    }

    public void depend2(Interface2 i){
        i.operate2();
    }

    public void depend3(Interface2 i){
        i.operate3();
    }
}

class B { //B 类通过接口Interface1 依赖(使用)D类，但是只会用到1，4，5方法

    public void depend1(Interface1 i){
        i.operate1();
    }

    public void depend4(Interface3 i){
        i.operate4();
    }

    public void depend5(Interface3 i){
        i.operate5();
    }
}
