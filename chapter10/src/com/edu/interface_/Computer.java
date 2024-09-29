package com.edu.interface_;

public class Computer {
    // 计算机工作
    public void work(UsbInterface usbInterface) {
        // 通过接口调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}
