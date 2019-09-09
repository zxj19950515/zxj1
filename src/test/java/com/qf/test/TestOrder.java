package com.qf.test;

import com.qf.common.util.MyUtil;
import com.qf.entity.TOrder;
import com.qf.entity.TProduct;
import com.qf.entity.vo.OrderVO;
import com.qf.service.IOrderService;
import com.qf.service.IProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring-context*.xml")
public class TestOrder {

    @Autowired
    private IOrderService orderService;


    @Autowired
    private IProductService productService;


    @Test
    public void testGetOrder(){

        orderService.getList(20090704001L);


    }






    @Test
    public void addOrder(){
        //需要编写数据
        OrderVO orderVO = new OrderVO();
        TOrder tOrder = new TOrder();
        tOrder.setUserId(1L);
        tOrder.setOrderPrice(998877L);
        tOrder.setOrderFlag((short)0);
        tOrder.setOrderId(Long.parseLong(MyUtil.getCurrentTime()));
        tOrder.setOrderAddr("杭州旺田大酒店");
        tOrder.setOrderTel("18888887878");
        tOrder.setOrderUser("李旸");
        tOrder.setCreatedTime(new Date());
        tOrder.setUpdatedTime(new Date());
        orderVO.settOrder(tOrder);

        //========


        List<TProduct> products = productService.getProducts();


        orderVO.setProducts(products);

        //=====orderVO封装完毕===

        //调用service插入数据

        orderService.addOrder(orderVO);


    }

}
