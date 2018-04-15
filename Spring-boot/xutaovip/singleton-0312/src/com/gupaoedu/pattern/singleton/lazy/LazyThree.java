package com.gupaoedu.pattern.singleton.lazy;
/**
 * 线程绝对安全的写法
 * 懒汉式单例
 * 在外部需要的时候才会实例化
 */
public class LazyThree {

    /*
     * 单例对象
     * volatile修饰符阻止了变量访问前后的指令重排，保证了指令执行顺序
     */
    private volatile static LazyThree instance = null;

    private LazyThree(){}

    public static LazyThree getInstance() {
        if(instance == null){             //双重检测机制
            synchronized (LazyTwo.class){   //同步锁
                if (instance == null){    //双重检测机制
                    instance = new LazyThree();
                }
            }
        }
        return instance;
    }
}
