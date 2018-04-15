package com.gupaoedu.vip.pattern.proxy.cglib;

public class CglibTest {

    public static void main(String[] args) {
        try {
            ZhangSan obj = (ZhangSan) new CglibMeiPo().getInstance(ZhangSan.class);
            obj.findLover();
            System.out.println(obj.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
