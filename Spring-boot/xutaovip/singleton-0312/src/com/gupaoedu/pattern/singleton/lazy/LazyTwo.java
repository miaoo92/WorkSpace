package com.gupaoedu.pattern.singleton.lazy;

/**
 * 线程安全的写法，但不是绝对安全
 * 这里涉及到了JVM编译器的指令重排。

 指令重排是什么意思呢？比如java中简单的一句 instance = new Singleton，会被编译器编译成如下JVM指令：

 memory =allocate();    //1：分配对象的内存空间
 ctorInstance(memory);  //2：初始化对象
 instance =memory;     //3：设置instance指向刚分配的内存地址

 但是这些指令顺序并非一成不变，有可能会经过JVM和CPU的优化，指令重排成下面的顺序：

 memory =allocate();    //1：分配对象的内存空间
 instance =memory;     //3：设置instance指向刚分配的内存地址
 ctorInstance(memory);  //2：初始化对象

 当线程A执行完1,3,时，instance对象还未完成初始化，但已经不再指向null。此时如果线程B抢占到CPU资源，
 执行  if（instance == null）的结果会是false，从而返回一个没有初始化完成的instance对象。
 * 懒汉式单例
 * 在外部需要的时候才会实例化
 */
public class LazyTwo {

    /**单例对象*/
    private static LazyTwo instance = null;

    //私有构造方法
    private LazyTwo(){}

    /**
     * 1.为了防止new LazyTwo被执行多次，因此在new之前加上synchronized同步锁，锁住整个类
     * 2.进入synchronized临界区以后，还要再做一次判空。因为当两个线程同时访问的时候，线程A构建完对象，线程B也通过了最初的判空验证，
     * 不做第二次判空的话，线程B还是会再次构建instance对象。
     * @return
     */
    public static LazyTwo getInstance() {
        if(instance == null){             //双重检测机制
            synchronized (LazyTwo.class){   //同步锁
                if (instance == null){    //双重检测机制
                    instance = new LazyTwo();
                }
            }
        }
        return instance;
    }
}
