package com.wang.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.mapper.UserMapper;
import com.wang.provider.DemoService;

/**
 *@auth wws
 *@date 2018年3月31日---下午4:30:34
 *
 **/
public class DubboTest {
  
    public static void main(String[] args) throws IOException {
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
      context.start();
      System.out.println("-----dubbo开启-----");
      DemoService demoService = (DemoService) context.getBean("demoService");
      System.out.println(demoService.sayHello("hello"));
      System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }

}
