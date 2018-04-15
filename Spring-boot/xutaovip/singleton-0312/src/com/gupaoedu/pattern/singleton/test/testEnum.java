package com.gupaoedu.pattern.singleton.test;

import com.gupaoedu.pattern.singleton.singleEnum.SingletonEnum;
import com.gupaoedu.pattern.singleton.staticed.inner.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射来获取单例，但是显然，枚举类是无法获取的
 */
public class testEnum {

    public static void main(String[] args) {
        Constructor constructor = null;
        try {
            constructor = SingletonEnum.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton singleton1 = (Singleton) constructor.newInstance();
            Singleton singleton2 = (Singleton) constructor.newInstance();
            System.out.println(singleton1.equals(singleton2));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
