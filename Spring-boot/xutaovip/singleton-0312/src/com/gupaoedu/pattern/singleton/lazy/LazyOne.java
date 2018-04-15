package com.gupaoedu.pattern.singleton.lazy;

/**
 * 线程不安全写法
 * 懒汉式单例
 * 在外部需要的时候才会实例化
 */
public class LazyOne {

    private static  LazyOne instance = null;

    //私有构造函数
    private LazyOne(){}

    //静态工厂方法
    //这种写法不是线程安全的
    //因为假设LazyOne类刚刚被初始化，instance还是空的，这时候两个线程同时访问getInstance方法，
    //因为instance对象为空，所以两个线程同时通过了条件判断，开始执行new操作，那么显然instance被构建了两次
    public static LazyOne getInstance(){
        if(instance == null){
            instance = new LazyOne();
        }
        return instance;
    }

}
