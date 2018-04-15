package com.gupaoedu.pattern.singleton.singleEnum;

/**
 * 使用枚举实现的单例模式不仅能够防止反射构造对象，而且可以保证线程安全
 * 不过也有唯一的缺点，就是它并非是使用懒加载，其单例对象是在枚举类被加载的时候被初始化
 */
public enum SingletonEnum {
    INSTANCE;
}
