package icu.cccccyq.interfacetest;

public class interface01 {
    public static void main(String[] args) {
        //create devices
        camera camera1 = new camera();
        phone phone1 = new phone();
        computer computer1 = new computer();
        computer1.work(phone1);
        System.out.println("----");
        computer1.work(camera1);
    }
}
//test