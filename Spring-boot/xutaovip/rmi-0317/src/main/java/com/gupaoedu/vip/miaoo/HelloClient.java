package com.gupaoedu.vip.miaoo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
    public static void main(String[] args) {
        try {
            ISayHello hello = (ISayHello)Naming.lookup("rmi://localhost:8888/sayHello");
            System.out.println(hello.sayHello("feifei"));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
