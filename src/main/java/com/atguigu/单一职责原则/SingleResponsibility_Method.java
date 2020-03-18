package com.atguigu.单一职责原则;

/**
 * 单一职责原则的主义事项和细节
 * ① 降低类的复杂度，一个类只负责一项职责
 * ② 提高类的可读性，可维护性
 * ③ 降低变更引起的风险
 * ④ 通常情况下，我们应当遵守单一职责原则。只有逻辑足够简单，才可以在代码级违反单一职责原则；只有类中方法数量足够少，可以在方法级别保持单一职责原则
 *
 * @author lhtao
 * @date 2020/3/18 16:56
 */
public class SingleResponsibility_Method {

    public static void main(String[] args) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.runAir("飞机");
        vehicle.runLoad("坦克");
        vehicle.runWater("船");
    }
}

/**
 * 分析
 * 这种修改方法没有对原来的类做大的修改，只是增加方法
 * 这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上仍然遵守单一职责原则
 */
class Vehicle {

    public void runLoad(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水上跑");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天上跑");
    }
}
