package com.atguigu.接口隔离原则;

/**
 * @author lhtao
 * @date 2020/3/19 10:55
 */
public class Segregation1 {

    public static void main(String[] args) throws Exception {
        new A().depend1(new C());
        new B().depend1(new D());
    }
}

interface Interface1 {

    void operate1();
    void operate2();
    void operate3();
    void operate4();
    void operate5();
}

class C implements Interface1 {

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

    @Override
    public void operate4() {
        System.out.println("C operate4");
    }

    @Override
    public void operate5() {
        System.out.println("C operate5");
    }
}

class D implements Interface1 {

    @Override
    public void operate1() {
        System.out.println("D operate1");
    }

    @Override
    public void operate2() {
        System.out.println("D operate2");
    }

    @Override
    public void operate3() {
        System.out.println("D operate3");
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

    public void depend2(Interface1 i){
        i.operate2();
    }

    public void depend3(Interface1 i){
        i.operate3();
    }
}

class B { //B 类通过接口Interface1 依赖(使用)D类，但是只会用到1，4，5方法

    public void depend1(Interface1 i){
        i.operate1();
    }

    public void depend4(Interface1 i){
        i.operate4();
    }

    public void depend5(Interface1 i){
        i.operate4();
    }
}