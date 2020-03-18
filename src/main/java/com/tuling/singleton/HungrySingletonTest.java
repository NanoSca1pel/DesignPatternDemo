package main.java.com.tuling.singleton;

import java.io.*;

/**
 * 饿汉式
 * @author lhtao
 * @date 2020/3/17 16:03
 */
public class HungrySingletonTest {


    public static void main(String[] args) throws Exception {

        /** 1 */
        /*HungrySingleton instance = HungrySingleton.instance;
        HungrySingleton instance1 = HungrySingleton.instance;
        System.out.println(instance==instance1);*/

        /** 2 */
        /*HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance1 = HungrySingleton.getInstance();
        System.out.println(instance==instance1);*/

        /** 3 */
        /*InnerClassSingletonTest innerClassSingleton = InnerClassSingletonTest.getInstance();
        InnerClassSingletonTest innerClassSingleton1 = InnerClassSingletonTest.getInstance();
        System.out.println(innerClassSingleton == innerClassSingleton1);*/

        /** 4 */
        /*Constructor<InnerClassSingletonTest> declaredConstructor = InnerClassSingletonTest.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingletonTest innerClassSingleton = declaredConstructor.newInstance();
        InnerClassSingletonTest innerClassSingleton1 = declaredConstructor.newInstance();
        System.out.println(innerClassSingleton == innerClassSingleton1);*/

        /** 5 */
        InnerClassSingletonTest instance = InnerClassSingletonTest.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testSerializable"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testSerializable"));
        InnerClassSingletonTest o = (InnerClassSingletonTest) ois.readObject();
        System.out.println(o == instance);
    }

}


class HungrySingleton {

    private HungrySingleton(){}

    /** 1 */
    /*public final static HungrySingleton instance = new HungrySingleton();*/

    /** 2 */
    private static HungrySingleton instance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return instance;
    }

}

/** 3 */
/*
class InnerClassSingletonTest {

    private InnerClassSingletonTest(){}

    private static class innerClassSingleton{
        private static InnerClassSingletonTest innerClassSingletonTest = new InnerClassSingletonTest();
    }

    public static InnerClassSingletonTest getInstance(){
        return innerClassSingleton.innerClassSingletonTest;
    }
}*/

/** 4 */
/*class InnerClassSingletonTest {

    private InnerClassSingletonTest(){

        if (InnerClassSingleton.innerClassSingletonTest != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    private static class InnerClassSingleton{
        private static InnerClassSingletonTest innerClassSingletonTest = new InnerClassSingletonTest();
    }

    public static InnerClassSingletonTest getInstance(){
        return InnerClassSingleton.innerClassSingletonTest;
    }
}*/

/** 5 */
class InnerClassSingletonTest implements Serializable {

    private InnerClassSingletonTest(){

        if (InnerClassSingleton.innerClassSingletonTest != null) {
            throw new RuntimeException("单例不允许多个实例");
        }
    }

    private static class InnerClassSingleton{
        private static InnerClassSingletonTest innerClassSingletonTest = new InnerClassSingletonTest();
    }

    public static InnerClassSingletonTest getInstance(){
        return InnerClassSingleton.innerClassSingletonTest;
    }

    static final Long serialVersionUID = 42L;

    Object readResolve() throws ObjectStreamException{
        return InnerClassSingleton.innerClassSingletonTest;
    }
}
