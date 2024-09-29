package com.edu.interface_;

public class InterfacePolyArray {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[5];
        usbs[0] = new ApplePhone();
        usbs[1] = new CannoCamera();
        usbs[2] = new CannoCamera();
        usbs[3] = new ApplePhone();
        usbs[4] = new CannoCamera();
        for (int i = 0; i < usbs.length; i++) {
            use(usbs[i]);
        }

    }

    public static void use(Usb usb) {
        usb.open(); // 动态绑定
        if (usb instanceof ApplePhone) {
            ((ApplePhone) usb).call(); // 向下转型
        }
        usb.close();
        System.out.println("=========");
    }
}
interface Usb {
    void open();
    void close();
}
class  ApplePhone implements Usb {
    public void call() {
        System.out.println("打电话");
    }

    @Override
    public void open() {
        System.out.println("手机开机");
    }

    @Override
    public void close() {
        System.out.println("手机关机");
    }
}

class CannoCamera implements Usb {

    @Override
    public void open() {
        System.out.println("相机开机");
    }

    @Override
    public void close() {
        System.out.println("相机关机");
    }
}