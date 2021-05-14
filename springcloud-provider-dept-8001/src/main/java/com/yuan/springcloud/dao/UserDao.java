package com.yuan.springcloud.dao;

import com.yuan.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    public Dept queryDeptById(Long id);
}
