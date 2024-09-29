package com.edu.extend_.exercise;

public class ExtendsExercise03 {
    public static void main(String[] args) {
        PC pc = new PC("甲芯片", "甲内存", "甲硬盘", "甲品牌");
        pc.printPC();

        NotePad notePad = new NotePad("乙芯片", "乙内存", "乙硬盘", "乙颜色");
        notePad.printNotePad();
    }
}

class PC extends Computer {
    private String brand;

    public PC(String cpu, String memory, String harddisk, String brand) {
        super(cpu, memory, harddisk);
        this.setBrand(brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void printPC() {
        System.out.println(getBrand() + " " + getDetail());
    }
}

class NotePad extends Computer {
    private String color;

    public NotePad(String cpu, String memory, String harddisk, String color) {
        super(cpu, memory, harddisk);
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printNotePad() {
        System.out.println(getColor() + " " + getDetail());
    }
}