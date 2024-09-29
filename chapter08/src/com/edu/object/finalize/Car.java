package com.edu.object.finalize;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("汽车对象" + name + "马上将被销毁");;
        System.out.println("释放对应资源");
    }

}
