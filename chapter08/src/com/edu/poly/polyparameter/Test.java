package com.edu.poly.polyparameter;

public class Test {
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getName() + "的年工资是" + e.getAnnual());
    }

    public void testWork(Employee e) {
        if (e instanceof Staff) {
            ((Staff) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manage();
        } else {
            System.out.println("传入类型错误");
        }
    }
}
