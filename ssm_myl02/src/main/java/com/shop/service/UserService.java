package com.shop.service;

import com.shop.domain.User;

import java.util.List;

public interface UserService {
    List<User> checkLogin(String username,String password);
}
