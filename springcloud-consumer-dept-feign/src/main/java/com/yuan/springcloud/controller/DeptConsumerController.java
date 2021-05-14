package com.yuan.springcloud.controller;

import com.yuan.springcloud.pojo.Dept;
import com.yuan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    //feign：通过接口方式访问
    //启动类要加开启扫描Feign的注解，不然会报错
    @Autowired
    private DeptClientService service=null;

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        System.out.println("查询某个用户");
        return this.service.queryById(id);
    }
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept){
        return this.service.addDept(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return this.service.queryAll();
    }

}
