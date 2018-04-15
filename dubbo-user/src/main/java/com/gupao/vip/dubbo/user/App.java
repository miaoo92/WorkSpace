package com.gupao.vip.dubbo.user;

import com.gupao.vip.dubbo.order.DoOrderRequest;
import com.gupao.vip.dubbo.order.DoOrderResponse;
import com.gupao.vip.dubbo.order.IOrderservice;
import javassist.ClassPath;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");

        IOrderservice service = (IOrderservice ) context.getBean("orderService");

        DoOrderRequest request = new DoOrderRequest();
        request.setName("xutao");

        DoOrderResponse response = service.doOrder(request);
        System.out.println(response);

    }
}
