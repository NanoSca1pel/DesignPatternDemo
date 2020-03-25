package com.atguigu.里氏替换原则.改进;

/**
 * @author lhtao
 * @date 2020/3/24 16:51
 */
public class LiskovImprove {

    public static void main(String[] args) throws Exception {

        System.out.println(new A().func1(11, 3));

        System.out.println(new B().func3(11, 3));
    }
}

//创建一个更加基础的基类
class Base {
    //把更加基础的方法和成员写到Base类中
}

class A extends Base{

    //返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B extends Base {

    //如果B需要用到A的方法，可以使用组合关系
    private A a = new A();

    public int func1(int num1, int num2) {
        return num1 + num2;
    }

    public int func2(int num1, int num2) {
        return func1(num1,num2) + 1;
    }

    public int func3(int num1, int num2) {
        return this.a.func1(num1, num2);
    }
}
