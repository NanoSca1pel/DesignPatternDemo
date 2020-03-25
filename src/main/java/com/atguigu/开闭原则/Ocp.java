package com.atguigu.开闭原则;

/**
 * ①优点是比较好理解，简单易操作
 * ②缺点是违反了设计模式的ocp原则，即对外扩展开放(提供方),对修改关闭(使用方)
 *   即当我们给类增加新功能的时候，尽量不要修改代码，或者尽可能少修改代码
 * ③比如我们这时要新增加一个图形种类 三角形，我们需要做如下修改
 *
 * @author lhtao
 * @date 2020/3/25 10:25
 */
public class Ocp {
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
        if (s.type == 1) {
            drawRectangle(s);
        } else if (s.type == 2) {
            drawCircle(s);
        } else if (s.type == 3) {
            drawTriangle(s);  //新增三角形判断
        }
    }

    public void drawRectangle(Shape r) {
        System.out.println("矩形");
    }

    public void drawCircle(Shape r) {
        System.out.println("圆形");
    }

    //新增三角形方法
    public void drawTriangle(Shape r) {
        System.out.println("三角形");
    }
}

class Shape {

    int type;
}


class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.type = 2;
    }
}

//新增三角形类  提供方
class Triangle extends Shape {
    Triangle() {
        super.type = 3;
    }
}