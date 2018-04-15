package com.gupaoedu.vip.pattern.proxy.jdk;

import com.gupaoedu.vip.pattern.proxy.staticed.Person;

public class Xiemu implements Person{

    public void findLover(){
        System.out.println("白富美");
        System.out.println("腿长的");

    }

    public void findJob() {
        System.out.println("月薪20K以上");
        System.out.println("xiemu找工作");
    }

    public void buy() {
        System.out.println("xiemu买东西");
    }
}
