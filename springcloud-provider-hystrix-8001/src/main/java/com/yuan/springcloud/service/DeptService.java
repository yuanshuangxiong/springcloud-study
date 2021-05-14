package com.yuan.springcloud.service;

import com.yuan.springcloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    public boolean addDepth(Dept dept);

    public Dept queryById(Long id);

    public List<Dept> queryAll();
}
