package com.edu.homework;

import java.util.Scanner;

public class Homework06 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.passRiver();
        tang.common();
        tang.volcano();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("一般情况请输入 y , 遇到大河请输入 n ");
//        char choice = scanner.next().charAt(0);
//        if (choice != 'y') {
//            p1.setVehicles(boat);
//        }
//        p1.m1();
    }
}

interface Vehicles {
    String work();
}

class Horse implements Vehicles {

    @Override
    public String work() {
        return "一般骑马";
    }
}

class Boat implements Vehicles {

    @Override
    public String work() {
        return "过河坐船";
    }
}
class Airplane implements Vehicles {

    @Override
    public String work() {
        return "过火焰山坐飞机";
    }
}
class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            setVehicles(TransportationToolFactory.getBoat());
        }
        System.out.println(name + vehicles.work());
    }

    public void common() {
        if (!(vehicles instanceof Horse)) {
            setVehicles(TransportationToolFactory.getHorse());
        }
        System.out.println(name + vehicles.work());
    }

    public void volcano() {
//        setVehicles(new Vehicles() {
//            @Override
//            public String work() {
//                return "过火焰山坐飞机";
//            }
//        });
        if (!(vehicles instanceof Airplane)) {
            setVehicles(TransportationToolFactory.getAirplane());
        }
        System.out.println(name + vehicles.work());
    }
}

class TransportationToolFactory {
    // 马始终是同一匹马
    private static final Horse horse = new Horse();

    private TransportationToolFactory() {
    }

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Airplane getAirplane() {
        return new Airplane();
    }
}
