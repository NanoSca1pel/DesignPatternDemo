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
public class SingleResponsibility_Class {

    public static void main(String[] args) throws Exception {
        LoadVehicle loadVehicle = new LoadVehicle();
        loadVehicle.run("坦克");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("船");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

/**
 * 分析
 * 遵守单一职责原则
 * 但是这样做的改动很大，即将类分解，同时修改客户端
 */
class LoadVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上跑");
    }
}


class WaterVehicle {

    public void run(String vehicle) {
        System.out. println(vehicle + "在水上跑");
    }
}

class AirVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在天上跑");
    }
}