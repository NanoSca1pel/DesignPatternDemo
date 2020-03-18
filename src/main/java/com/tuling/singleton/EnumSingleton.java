package main.java.com.tuling.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 饿汉式 枚举
 * @author lhtao
 * @date 2020/3/17 16:20
 */
public enum EnumSingleton {

    INSTANCE;

}

class EnumTest{
    public static void main(String[] args) throws Exception {
        /** 1 */
        /*EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        System.out.println(instance == instance1);*/

        /** 2 */
        /*Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton = declaredConstructor.newInstance("INSTANCE", 0);*/

        /** 3 */
        EnumSingleton instance = EnumSingleton.INSTANCE;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("enumSingleton"));
        oos.writeObject(instance);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("enumSingleton"));
        EnumSingleton o = (EnumSingleton) ois.readObject();
        System.out.println(o == instance);
    }
}
