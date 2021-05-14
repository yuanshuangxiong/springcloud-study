package com.yuan.springcloud;

import com.yuan.springcloud.pojo.Dept;
import com.yuan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;



    //导的是spring的包
    @Autowired
    DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDepth(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id ){
        Dept dept = deptService.queryById(id);
        if(dept==null){
            throw new RuntimeException("Fail");
        }
        return dept;
    }


    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
          return deptService.queryAll();
    }

    //注册进来的微服务
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务的清单
        List<String> services=client.getServices();
        System.out.println("discovery=>services"+services);
        //通过具体的微服务id,也就是applicationName
        List<ServiceInstance> instances = client.getInstances("springcloud-provider-dept");

        for (ServiceInstance instance:instances){
            System.out.println(instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId());
        }
        return this.client;

    }

}
