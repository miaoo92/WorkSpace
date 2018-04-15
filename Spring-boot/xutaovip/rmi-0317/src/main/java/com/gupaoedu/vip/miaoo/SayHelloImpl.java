package com.gupaoedu.vip.miaoo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHelloImpl extends UnicastRemoteObject implements ISayHello {

    public SayHelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return "hello miaoo ->"+name;
    }
}
