package main.java.com.tuling.factoryMethod;

/**
 * 工厂方法模式
 * @author lhtao
 * @date 2020/3/18 9:34
 */
public class FactoryMethodDemo {
    public static void main(String[] args) throws Exception {
        Application application = new ProductB();
        Product product = application.getObject();
        product.printProductInfo();
    }
}

interface Product {

    void printProductInfo();
}

class ProductA extends Application implements Product {

    @Override
    public void printProductInfo() {
        System.out.println("productA");
    }

    @Override
    Product createProduct() {
        return new ProductA();
    }
}

class ProductB extends Application implements Product {

    @Override
    public void printProductInfo() {
        System.out.println("productB");
    }

    @Override
    Product createProduct() {
        return new ProductB();
    }
}

abstract class Application {

    abstract Product createProduct();

    Product getObject() {
        //业务代码
        return createProduct();
    }
}
