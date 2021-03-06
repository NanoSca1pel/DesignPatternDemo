package com.atguigu.依赖倒转原则.依赖关系传递的三种方式;

/**
 * @author lhtao
 * @date 2020/3/21 11:08
 */
public class DependencyPass {

    public static void main(String[] args) throws Exception {
        new OpenAndClose().open( ()-> System.out.println("interface"));

        new OpenAndCloseConstruct(()-> System.out.println("construct")).open();

        OpenAndCloseSetter openAndCloseSetter = new OpenAndCloseSetter();
        openAndCloseSetter.setTv(()-> System.out.println("setter"));
        openAndCloseSetter.open();

        System.out.println("--------------------");

        new OpenAndClose().open(new Changhong());

        new OpenAndCloseConstruct(new ChanghongConstruct()).open();

        OpenAndCloseSetter openAndCloseSetter1 = new OpenAndCloseSetter();
        openAndCloseSetter1.setTv(new ChanghongSetter());
        openAndCloseSetter1.open();


    }
}

/**
 * 方式一：通过接口传递实现依赖
 */

interface IOpenAndClose{

    void open(ITV tv);  //接口方法，接收接口
}

interface ITV {  //ITV接口
    void play();
}

class Changhong implements ITV {

    @Override
    public void play() {
        System.out.println("长虹电视机打开");
    }
}

//实现接口
class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV tv) {
        tv.play();
    }
}


/**
 * 方式二：通过构造方法依赖传递
 */
interface IOpenAndCloseConstruct{
    void open();
}

interface ITVConstruct{
    void play();
}

class ChanghongConstruct implements ITVConstruct {

    @Override
    public void play() {
        System.out.println("长虹电视机打开");
    }
}

class OpenAndCloseConstruct implements IOpenAndCloseConstruct{

    private ITVConstruct itv;

    public OpenAndCloseConstruct(ITVConstruct itv) {
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}

/**
 * 通过setter方法实现依赖传递
 */
interface IOpenAndCloseSetter{
    void open();

    void setTv(ITVSetter itv);
}

interface ITVSetter{
    void play();
}

class ChanghongSetter implements ITVSetter {

    @Override
    public void play() {
        System.out.println("长虹电视机打开");
    }
}

class OpenAndCloseSetter implements IOpenAndCloseSetter{

    private ITVSetter itv;

    @Override
    public void open() {
        this.itv.play();
    }

    @Override
    public void setTv(ITVSetter itv) {
        this.itv = itv;
    }
}