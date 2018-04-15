package com.gupaoedu.vip.pattern.proxy.staticed;

public class StaticProxyTest {

    public static void main(String[] args) {

        Son son = new Son();
        //只能帮儿子找对象
        Father father = new Father(son);
        father.findLover();

    }
}
