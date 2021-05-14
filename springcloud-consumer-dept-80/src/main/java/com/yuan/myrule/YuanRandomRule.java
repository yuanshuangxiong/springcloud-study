//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yuan.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
//import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class YuanRandomRule extends AbstractLoadBalancerRule {
    //自定义规则：总共3个服务，每个服务访问五次，然后换下一个服务
    //total 默认为0，如果等于五，我们指向下一个服务及节点
    //index=0,默认为0，如果total等于五，index++
    //
    private int total=0;//被调用的次数
    private int currentIndex=0;//当前是谁在提供服务

    public YuanRandomRule() {
    }

//    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//获取活着的服务
                List<Server> allList = lb.getAllServers();//所有服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

              //自定义规则
                if(total<5){
                    server  = upList.get(currentIndex);
                    total++;
                }else{
                    total=0;
                    currentIndex++;
                    if(currentIndex>=upList.size()){
                        currentIndex=0;
                    }
                    server  = upList.get(currentIndex);
                    total++;
                }

//                int index = this.chooseRandomInt(serverCount);//生成区间随机数
//                server = (Server)upList.get(index);//通过活着的服务随机获取某一个
                //=======================================
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
