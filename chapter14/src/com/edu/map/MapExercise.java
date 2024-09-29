package com.edu.map;

import java.util.*;

@SuppressWarnings({"all"})
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        Employee jack = new Employee("jack", 25300, "0013");
        Employee king = new Employee("king", 12000, "0156");
        Employee tom = new Employee("tom", 19500, "0100");

        hashMap.put(jack.getId(), jack);
        hashMap.put(king.getId(), king);
        hashMap.put(tom.getId(), tom);

        System.out.println("=======entrySet for========");
        // entrySet for
        Set entrySet = hashMap.entrySet();
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;
            printSalary18000(entry.getValue());
        }
        System.out.println("=======entrySet 迭代器========");
        // entrySet 迭代器
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            printSalary18000(entry.getValue());
        }

        System.out.println("=======keySet for========");
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            printSalary18000(hashMap.get(key));
        }

        System.out.println("=======keySet 迭代器========");
        Iterator iterator1 = keySet.iterator();
        while (iterator1.hasNext()) {
            Object key = iterator1.next();
            printSalary18000(hashMap.get(key));
        }

        System.out.println("=======values for========");
        Collection values = hashMap.values();
        for (Object value : values) {
            printSalary18000(value);
        }

        System.out.println("=======values 普通for========");
        for (int i = 0; i < values.size(); i++) {
            printSalary18000(values.toArray()[i]);
        }

        System.out.println("=======values 迭代器========");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            printSalary18000(iterator2.next());
        }
    }

    /**
     * 打印工资超过18000的员工对象
     *
     * @param obj 某员工对象
     */
    public static void printSalary18000(Object obj) {
        if (!(obj instanceof Employee)) {
            throw new RuntimeException("类型错误");
        }
        Employee employee = (Employee) obj;
        if (employee.getSalary() > 18000) {
            System.out.println(employee);
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private String id;

    public Employee(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}