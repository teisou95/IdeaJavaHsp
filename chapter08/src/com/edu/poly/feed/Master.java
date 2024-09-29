package com.edu.poly.feed;

public class Master {
    private String name;

    public Master(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void feed(Animal animal, Food food) {
        System.out.println(this.name + "给" + animal.getName() + "喂食" + food.getName());
    }

//    public void feed(Cat cat, Fish fish) { // 简化掉了
//        System.out.println(this.name + "给" + cat.getName() + "喂食" + fish.getName());
//    }
}
