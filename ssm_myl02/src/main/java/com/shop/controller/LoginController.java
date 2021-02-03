package com.shop.controller;


import com.shop.domain.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String testLoginPage() throws IOException {
        return "login";
    }

    @RequestMapping(value = "/doLogin")
    public String testLogin(HttpSession session, String username, String password, Model model, String code) {

        String codeTest = (String) session.getAttribute("codeTest");

        if (!codeTest.equalsIgnoreCase(code)) {
            model.addAttribute("errorMsg", "验证码错误!!");
            return "login";
        }


        List<User> users = this.userService.checkLogin(username, password);
        if (users != null && users.size() > 0) {
            User user = users.get(0);
            model.addAttribute("user",user);
            return "redirect:product/product";
        }else {
            model.addAttribute("errorMsg","用户名或密码错误");

            return "login";
        }
    }
}
