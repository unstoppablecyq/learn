package icu.cccccyq.interfacetest;

public class camera implements usb{
    @Override
    public void start() {
        System.out.println("camera start");
    }

    @Override
    public void stop() {
        System.out.println("camera end");
    }
}
//test