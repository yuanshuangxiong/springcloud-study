package com.yuan.springcloud.service;

import com.yuan.springcloud.pojo.Dept;
import org.springframework.stereotype.Service;

public interface UserService {
    public Dept queryDeptById(Long id);

}
