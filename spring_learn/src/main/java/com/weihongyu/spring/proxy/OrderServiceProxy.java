package com.weihongyu.spring.proxy;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:35
 * @Description:订单类代理，业务增强
 */
public class OrderServiceProxy implements OrderService{

    private OrderService orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("----log-----");

        orderService.showOrder();
    }
}
