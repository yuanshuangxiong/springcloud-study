package com.yuan.springcloud;

import com.yuan.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    //消费者：不应该有service层
    //RestTemplate .... 提供多种便捷访问远程http的方法，简单的restful服务模板
    @Autowired
    private RestTemplate restTemplate;

    //通过服务名来访问
//    private static final String REST_URL_PREAFIX="http://localhost:8001";
    private static final String REST_URL_PREAFIX="http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
         return restTemplate.getForObject(REST_URL_PREAFIX+"/dept/get/"+id,Dept.class);
    }
    @RequestMapping("/consumer/dept/add")
    public Boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREAFIX+"/dept/add/",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREAFIX+"/dept/list",List.class);
    }

}
