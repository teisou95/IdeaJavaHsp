package com.edu.extend_.exercise;

public class Computer {
    private String cpu;
    private String memory;
    private String harddisk;

    public Computer(String cpu, String memory, String harddisk) {
        this.setCpu(cpu);
        this.setMemory(memory);
        this.setHarddisk(harddisk);
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHarddisk() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk = harddisk;
    }

    public String getDetail() {
        return cpu + " " + memory + " " + harddisk;
    }
}
