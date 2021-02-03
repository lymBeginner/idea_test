package com.shop.controller;

import com.shop.domain.Product;
import com.shop.service.ProductService;
import com.shop.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/product")
    public ModelAndView modelAndView() throws Exception {

        //模拟异常
//        int i = 1/0;

        /*if (true){
            throw new MyException("我的自定义错误");
        }
*/

        ModelAndView modelAndView = new ModelAndView();

        List<Product> productList = this.productService.getProductList();
        // 往model 域 中存数据
        // request.setAttbuite()
        modelAndView.addObject("productList", productList);

        modelAndView.setViewName("productList");

        return modelAndView;
    }

    // 根据商品的id 去查询出当前的商品信息
    //PathVariable：浏览器更喜欢的restful类型
    @RequestMapping(value = "/itemEdit.action/{id}")
    public ModelAndView getProductById(@PathVariable String id)
    {

//        String id = request.getParameter("id");
        ModelAndView modelAndView = new ModelAndView();
        Product product = this.productService.getProductById(id);

        modelAndView.setViewName("productItem");
        modelAndView.addObject("item",product);

        return modelAndView;

    }

    @RequestMapping(value = "/updateitem.action")
    public ModelAndView updateitem(Product product, MultipartFile pictureFile) throws IOException {
        //  获取文件名称

        String filename = pictureFile.getOriginalFilename();  //  time (6).jpg

        // 处理文件名
        //  .jpg
        String ext = filename.substring(filename.lastIndexOf("."));
        // 0b1220e6-9a08-450c-9372-34bcadb9900b.jpg
        String newFileName =  UUID.randomUUID().toString() + ext;
        // 获取文件类型
        String contentType = pictureFile.getContentType();
        // 获取大小
        long size = pictureFile.getSize();

        pictureFile.transferTo(new File("D:\\images\\"+newFileName));
        //  上传逻辑

        ModelAndView modelAndView = new ModelAndView();
//        Product product = new Product();
//        product.setId(Integer.parseInt(id));
//        product.setName(name);
//        product.setPrice(Float.parseFloat(price));
//        product.setDetail(detail);
        // 封装创建时间
        // product.setCreatetime(new Date());
        // service ->dao(mybatis 逆向工程)
        // alt+enter
        this.productService.updateitem(product);

        modelAndView.setViewName("success");

        return modelAndView ;
    }

    // 批量删除
    @RequestMapping(value = "/deleteItems.action")
    public ModelAndView deleteItems(String [] ids)
    {
        return null;
    }
}
