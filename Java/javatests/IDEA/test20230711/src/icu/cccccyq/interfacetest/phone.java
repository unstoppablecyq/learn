package icu.cccccyq.interfacetest;
//phone类实现usb接口，即实现接口声明的方法
public class phone implements usb{
    @Override
    public void start() {
        System.out.println("phone_start");
    }

    @Override
    public void stop() {
        System.out.println("phone_end");
    }
}
//test