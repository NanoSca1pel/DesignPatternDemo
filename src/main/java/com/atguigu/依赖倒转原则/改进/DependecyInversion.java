package com.atguigu.依赖倒转原则.改进;

/**
 * @author lhtao
 * @date 2020/3/19 12:02
 */
public class DependecyInversion {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Weixin());
    }
}

interface IReceiver {
    String getMessage();
}

class Email implements IReceiver{

    @Override
    public String getMessage() {
        return "电子邮件信息：hello！world！";
    }
}


class Weixin implements IReceiver{

    @Override
    public String getMessage() {
        return "微信信息：hello！OK！";
    }
}

class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getMessage());
    }
}
