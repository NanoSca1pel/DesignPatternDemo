package com.atguigu.开闭原则.改进;

/**
 * 方式一的改进思路
 * 思路：把创建Shape类做成抽象类，并提供一个抽象的draw方法，让子类去实现即可。
 *      这样我们有新的图形种类时，只需要让新的图形类继承Shape，并实现draw方法即可
 *      使用方的代码就不需要修改-->满足了开闭原则
 *
 * @author lhtao
 * @date 2020/3/25 10:25
 */
public class OcpImprove {
    public static void main(String[] args) throws Exception {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        //新增三角形调用
        graphicEditor.drawShape(new Triangle());
    }
}

//使用方
class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}

abstract class Shape {

    int type;

    //抽象方法
    abstract void draw();
}


class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }

    @Override
    void draw() {
        System.out.println("矩形");
    }
}

class Circle extends Shape {
    Circle() {
        super.type = 2;
    }

    @Override
    void draw() {
        System.out.println("圆形");
    }
}

//新增三角形类  提供方
class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("三角形");
    }
}