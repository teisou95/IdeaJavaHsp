package com.edu.poly.polyparameter;

/**
 *
 * 多态参数 多态数组
 * 方法定义的形参类型为父类类型,实际传入的允许为子类类型
 * 数组定义类型为父类类型,实际元素允许为子类类型
 */
public class PloyParameter {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Staff("wang", 8000);
        employees[1] = new Staff("li", 7500);
        employees[2] = new Manager("king", 20000, 50000);
        Test test = new Test();

        for (int i = 0; i < employees.length; i++) {
            test.showEmpAnnual(employees[i]);
            test.testWork(employees[i]);
        }

        test100(); // Non-static method 'test100()' cannot be referenced from a static context
    }
    public static void test100() {
        System.out.println("test100...");
    }
}
