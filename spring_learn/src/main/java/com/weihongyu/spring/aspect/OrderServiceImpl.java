package com.weihongyu.spring.aspect;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/14 21:35
 * @Description:订单类业务实现
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public void showOrder() {
        System.out.println("OrderServiceImpl.showOrder");
    }
}
