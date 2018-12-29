package com.gupaoedu.vip.dubbo.api.provider;

import com.gupaoedu.vip.dubbo.api.IGpHello;

public class GpHelloImpl implements IGpHello {
    @Override
    public String sayHello(String message) {

        return "Hello ,"+message;
    }
}
