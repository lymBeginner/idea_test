package com.shop.controller;
import com.shop.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TestController {

    @RequestMapping(value = "/testjson")
    @ResponseBody
    public Product testjson(Product product)
    {
        Product p = new Product();
        String name = product.getName();
        Float price = product.getPrice();

        p.setName(name);
        p.setPrice(price);
        System.out.println(product);

        return p;
    }

    @RequestMapping
    @ResponseBody
    public List<Product> testjson2(){

        //Integer id, String name, Float price, String pic, Date createtime, String detail
        Product p1 = new Product(1,"张三1",10.2f,"你好1",new Date(),"不错");
        Product p2 = new Product(2,"张三2",10.2f,"你好2",new Date(),"不错");
        Product p3 = new Product(3,"张三3",10.2f,"你好3",new Date(),"不错");

        List<Product> list = new ArrayList<Product>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        return list;
    }

    @RequestMapping(value = "/productlist")
    @ResponseBody
    public Map<String,Object> getProductList(){
        List<Product> list = new ArrayList<Product>();
        // ctrl + d   快速复制一行代码
        list.add(new Product(1,"小黄",10.20f,"xxx.jpg",new Date(),"很好"));
        list.add(new Product(2,"小黄2",10.20f,"xxx.jpg",new Date(),"很好"));
        list.add(new Product(3,"小黄3",10.20f,"xxx.jpg",new Date(),"很好"));
        list.add(new Product(4,"小黄4",10.20f,"xxx.jpg",new Date(),"很好"));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code",200);
        map.put("msg","返回数据成功");
        map.put("data",list);

        return map;
    }
}
