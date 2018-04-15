package com.gupaoedu.pattern.singleton.staticed.inner;

public class Singleton {

    private static class LazyHolder{
        private static final Singleton instance = new Singleton();
    }

    private Singleton(){}

    /*
    1.从外部无法访问静态内部类LazyHolder，只有当调用Singleton.getInstance()方法的时候，才能得到instance对象。
    2.instance对象初始化的时机并不是在单例类Singleton被加载的时候，而是在调用getInstance方法的，使得静态内部类
      LazyHolder被加载的时候。因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建线程安全的单例
     */
    public static Singleton getInstace(){
        return LazyHolder.instance;
    }
}
