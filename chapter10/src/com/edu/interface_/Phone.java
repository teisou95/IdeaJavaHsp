package com.edu.interface_;
// Phone 类 实现 Usb接口
// Class 'Phone' must either be declared abstract or implement abstract method 'start()' in 'UsbInterface'
public class Phone implements UsbInterface{
    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作");
    }
}
