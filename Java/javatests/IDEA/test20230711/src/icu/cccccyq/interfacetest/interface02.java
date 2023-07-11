package icu.cccccyq.interfacetest;

public class interface02 {
    public static void main(String[] args) {

    }
}
//test
public interface intef01{
    public int n1 = 10;
    //接口中抽象方法可以不要abstract，默认就是
    public void hi();

    //jdk8之后需要default关键字修饰才能有默认实现方法，例如下：
    public void ok();
}
class A implements intef01{

    @Override
    public void hi() {
        System.out.println("alt");
    }

    @Override
    public void ok() {
        System.out.println("enter");
    }
}