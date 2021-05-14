package com.yuan.springcloud.service;

import com.yuan.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

//降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id).
                        setDname("id=>"+id+"没有对应的信息，客户端提供了降级的信息，这个已经被关闭").
                        setDb_source("没有数据");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
