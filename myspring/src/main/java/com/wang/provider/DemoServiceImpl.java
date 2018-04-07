package com.wang.provider;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *@auth wws
 *@date 2018年3月31日---下午4:11:24
 *
 **/
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.RpcContext;

@Service(value="demoService")
public class DemoServiceImpl implements DemoService{

    public String sayHello(String name) {
      System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
      return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }

}
