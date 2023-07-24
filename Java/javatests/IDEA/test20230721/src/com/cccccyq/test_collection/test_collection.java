package com.cccccyq.test_collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings({"all"})
/**
 * @author cccccyq
 * @date 2023/7/24 16:19
 */
public class test_collection {
    public static void main(String[] args) {
//        List list = new ArrayList();
//        //add添加元素
//        list.add("cyq");
//        list.add(66);
//        list.add(true);
//        System.out.println(list);
//        //remove删除元素
//        list.remove(0);
//        list.remove(true);
//        //contains查找元素
//        list.contains("cyq");
//        //size获取元素个数
//        list.size();
//        //isEmpty判断是否为空
//        list.isEmpty();
//        //清空clear
//        list.clear();
//        //addALL 添加多个元素
//        ArrayList list6 = new ArrayList();
//        list.addAll(list6);
//        //containsALL:查找多个元素是否都存在
//        list.containsAll(list6);
//        //removeALL:删除多个元素
//        list.removeAll(list6);
//
        List list = new ArrayList();
        list.add(new Dog("1",3));
        list.add(new Dog("323",9));
        list.add(new Dog("11",54));
        for (Object Dog:list) {
            System.out.println("Dog"+Dog);
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog"+dog);
        }
    }
}
class Dog{
    private String Name;
    private int age;

    public Dog(String name, int age) {
        Name = name;
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                '}';
    }
}