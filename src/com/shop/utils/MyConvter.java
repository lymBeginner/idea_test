package com.shop.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConvter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {

        //  String 日期 -> Date 日期

        // 2020/10/10 19:00:10
        //..
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss").parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
