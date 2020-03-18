package com.tuling.abstractFactory;

/**
 * 抽象工厂模式
 * @author lhtao
 * @date 2020/3/18 9:54
 */
public class AbstractFactory {

    public static void main(String[] args) throws Exception {
        IDatabaseUtils mysql = new MysqlUtils();
        IConnect connection = mysql.getConnection();
        connection.connect();
        ICommand command = mysql.sendCommand();
        command.command();
        IClose close = mysql.closeConnection();
        close.close();
        System.out.println("-------------------------------");
        IDatabaseUtils oracle = new OracleUtils();
        IConnect oConnect = oracle.getConnection();
        oConnect.connect();
        ICommand oCommand = oracle.sendCommand();
        oCommand.command();
        IClose oClose = oracle.closeConnection();
        oClose.close();
    }

}

interface IConnect{
    void connect();
}

interface ICommand{
    void command();
}

interface IClose{
    void close();
}

interface IDatabaseUtils {
    IConnect getConnection();

    ICommand sendCommand();

    IClose closeConnection();
}


class MysqlConnect implements IConnect {

    @Override
    public void connect() {
        System.out.println("mysql connect");
    }
}

class MysqlCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("mysql command");
    }
}

class MysqlClose implements IClose {

    @Override
    public void close() {
        System.out.println("mysql close");
    }
}

class MysqlUtils implements IDatabaseUtils {

    @Override
    public IConnect getConnection() {
        return new MysqlConnect();
    }

    @Override
    public ICommand sendCommand() {
        return new MysqlCommand();
    }

    @Override
    public IClose closeConnection() {
        return new MysqlClose();
    }
}

class OracleConnect implements IConnect {

    @Override
    public void connect() {
        System.out.println("oracle connect");
    }
}

class OracleCommand implements ICommand {

    @Override
    public void command() {
        System.out.println("oracle command");
    }
}

class OracleClose implements IClose {

    @Override
    public void close() {
        System.out.println("oracle close");
    }
}

class OracleUtils implements IDatabaseUtils {

    @Override
    public IConnect getConnection() {
        return new OracleConnect();
    }

    @Override
    public ICommand sendCommand() {
        return new OracleCommand();
    }

    @Override
    public IClose closeConnection() {
        return new OracleClose();
    }
}