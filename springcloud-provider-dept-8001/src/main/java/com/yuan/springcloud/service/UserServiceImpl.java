package com.yuan.springcloud.service;

import com.yuan.springcloud.dao.UserDao;
import com.yuan.springcloud.pojo.Dept;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public Dept queryDeptById(Long id) {
        return userDao.queryDeptById(id);
    }
}
