package com.shop.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        String s = "默认错误:你好，出bug了";

        if (e instanceof MyException){
            s= ((MyException) e).msg;
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myMsg",s);
        modelAndView.setViewName("error");

        return modelAndView;
    }
}
