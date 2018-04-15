package com.gupao.vip.dubbo.order;

public interface IOrderservice {


    /**
     * 下单操作
     * @param request
     * @return
     */
    DoOrderResponse doOrder(DoOrderRequest request);
}
