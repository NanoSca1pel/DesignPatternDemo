package com.atguigu.里氏替换原则;

/**
 * @author lhtao
 * @date 2020/3/24 16:51
 */
public class Liskov {

    public static void main(String[] args) throws Exception {

        System.out.println(new A().func1(11, 3));

        System.out.println(new B().func1(11, 3));
    }
}

class A {

    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends A {

    @Override
    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1,num2) + 1;
    }
}
