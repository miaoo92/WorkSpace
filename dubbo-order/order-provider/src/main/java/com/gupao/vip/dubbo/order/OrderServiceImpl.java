package com.gupao.vip.dubbo.order;

public class OrderServiceImpl implements IOrderservice{

    public DoOrderResponse doOrder(DoOrderRequest request) {
        System.out.println("曾经来过："+request);
        DoOrderResponse response = new DoOrderResponse();
        response.setCode("10000");
        response.setMemo("处理成功");
        return response;
    }
}
