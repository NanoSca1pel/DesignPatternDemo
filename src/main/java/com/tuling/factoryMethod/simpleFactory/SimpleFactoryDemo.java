package main.java.com.tuling.factoryMethod.simpleFactory;

/**
 * 简单工厂模式
 * @author lhtao
 * @date 2020/3/18 9:10
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) throws Exception {
        Application application = new Application();
        Product product = application.getObject("productB");
        product.printProductInfo();
    }
}

interface Product {

    void printProductInfo();
}

class SimpleFactory {
    public static Product createProduct(String type) {
        if ("productA".equals(type)) {
            return new ProductA();
        } else if ("productB".equals(type)) {
            return new ProductB();
        }
        return null;
    }
}

class ProductA implements Product{

    @Override
    public void printProductInfo() {
        System.out.println("productA");
    }
}

class ProductB implements Product{

    @Override
    public void printProductInfo() {
        System.out.println("productB");
    }
}

class Application {

    public Application() {
    }

    private static Product createProduct(String type) {
        //业务代码
        return SimpleFactory.createProduct(type);
    }

    Product getObject(String type) {
        //业务代码
        return createProduct(type);
    }
}
