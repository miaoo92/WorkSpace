package com.gupaoedu.vip.pattern.proxy.jdk;

import com.gupaoedu.vip.pattern.proxy.staticed.Person;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

import static sun.misc.ProxyGenerator.generateProxyClass;

public class JDKProxyTest {

    public static void main(String[] args) {

        //原理
        //1.拿到被代理类的引用，并且获取到它的所有的接口。
        //2.JDK Proxy类重新生成一个新的类，同时新的类要实现被代理类所实现的所有接口
        //3.动态生成java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
        //4.编译新生成的Java代码.class文件
        //5.再重新加载到JVM中运行
        try {
            Person obj = (Person) new JDK58().getInstance(new Xiemu());
            System.out.println(obj.getClass().getName());
            obj.findJob();

            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
            FileOutputStream fileOutputStream = new FileOutputStream("E://$Proxy0.class");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
