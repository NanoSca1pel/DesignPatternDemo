package main.java.com.lht.singleton;

/**
 * 懒汉式
 * @author lhtao
 * @date 2020/3/17 15:34
 */
public class LazySingletonTest {

    public static void main(String[] args) throws Exception {

        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance1 = LazySingleton.getInstance();
        System.out.println(instance == instance1);

    }
}

class LazySingleton {

    private volatile static LazySingleton instance;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
