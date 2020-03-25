package com.atguigu.迪米特法则.改进;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照迪米特法则，应该避免类中出现这样非直接朋友关系的耦合
 * @author lhtao
 * @date 2020/3/25 13:55
 */
public class DemeterImprove {

    public static void main(String[] args) throws Exception {
        new SchoolManager().printAllEmployee(new CollegeManager());
    }
}

//学校总部员工
class SchoolEmployee{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

//学院员工
class CollegeEmployee {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

//管理学院员工的管理类
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllCollegeEmployee() {
        List<CollegeEmployee> list = new ArrayList<>(10);
        for (int i=1; i<=10; i++){
            CollegeEmployee employee = new CollegeEmployee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }

    //输出学院的员工方法
    public void printAllCollegeEmployee(){
        List<CollegeEmployee> list1 = this.getAllCollegeEmployee();
        System.out.println("-----------分公司员工-----------");
        list1.forEach(p-> System.out.println(p.getId()));
    }
}

//管理学校员工的管理类
//分析SchoolManager类的直接朋友类有哪些: SchoolEmployee、CollegeManager
//由此可见 CollegeEmployee以局部变量存在，不是直接朋友，而是一个陌生类。违背了迪米特法则
class SchoolManager {
    //返回学校总部的所有员工
    public List<SchoolEmployee> getAllSchoolEmployee() {
        List<SchoolEmployee> list = new ArrayList<>(10);
        for (int i=1; i<=5; i++){
            SchoolEmployee employee = new SchoolEmployee();
            employee.setId(i);
            list.add(employee);
        }
        return list;
    }


    //输出所有学校总部及学院员工信息
    void printAllEmployee(CollegeManager sub) {

        //避免迪米特法则： 将输出学院的员工方法，封装到CollegeManager中去
        /*List<CollegeEmployee> list1 = sub.getAllCollegeEmployee();
        System.out.println("-----------分公司员工-----------");
        list1.forEach(p-> System.out.println(p.getId()));*/

        sub.printAllCollegeEmployee();
        List<SchoolEmployee> list2 = this.getAllSchoolEmployee();
        System.out.println("-----------总部员工-----------");
        list2.forEach(p-> System.out.println(p.getId()));
    }
}
