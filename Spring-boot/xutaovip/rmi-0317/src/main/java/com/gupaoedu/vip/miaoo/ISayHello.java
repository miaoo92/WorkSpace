package com.gupaoedu.vip.miaoo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISayHello extends Remote{

    public String sayHello(String name) throws RemoteException;
}
