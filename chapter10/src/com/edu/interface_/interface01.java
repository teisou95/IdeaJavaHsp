package com.edu.interface_;

public class interface01 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Camera camera = new Camera();
        Computer computer = new Computer();

        computer.work(phone);
        computer.work(camera);
        computer.work(new Phone());
    }
}
