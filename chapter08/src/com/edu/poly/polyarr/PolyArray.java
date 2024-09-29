package com.edu.poly.polyarr;

/**
 * 多态数组:数组定义为父类类型,里面保存的实际元素类型为子类类型
 */
public class PolyArray {
    public static void main(String[] args) {
//        // 创建对象
//        Person jack = new Person("jack", 25);
//        Student wang = new Student("wang", 15, 82.5);
//        Student zhou = new Student("zhou", 16, 94);
//        Teacher naru = new Teacher("naru", 32, 30000);
//        Teacher kaori = new Teacher("nioi", 40, 25000);
//
//        // 创建多态数组
//        Person[] persons = {jack, wang, zhou, naru, kaori};

        Person[] persons = new Person[5];
        persons[0] = new Person("jack", 25);
        persons[1] = new Student("wang", 15, 82.5);
        persons[2] = new Student("zhou", 16, 94);
        persons[3] = new Teacher("naru", 32, 30000);
        persons[4] = new Teacher("nioi", 40, 25000);

        // 数组 for 循环,调用重写方法
        for (int i = 0; i < persons.length; i++) {
            persons[i].say(); // 动态绑定,按实际元素的对象运行类型,查找调用相应类型的方法
            System.out.println();
            // 两种方法调用子类特有方法
            // 1.父类写一样的方法,形成重写
            // 2.用 instanceof 判断元素对象的运行类型,属于哪个类,就向下转型调用方法
            if (persons[i] instanceof Student) {
                ((Student) persons[i]).study(); // 强转,调用子类方法
            } else if (persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            }
        }
    }
}
