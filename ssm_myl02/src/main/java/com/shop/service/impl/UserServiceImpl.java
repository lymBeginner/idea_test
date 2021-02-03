package com.shop.service.impl;

import com.shop.dao.UserMapper;
import com.shop.domain.User;
import com.shop.domain.UserExample;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> checkLogin(String username, String password) {

        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> list = this.userMapper.selectByExample(userExample);
        return list;
    }
}
