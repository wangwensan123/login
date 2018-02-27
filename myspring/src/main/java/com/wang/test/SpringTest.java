package com.wang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.mapper.UserMapper;
import com.wang.model.User;

public class SpringTest {

	 public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-common.xml");
		 UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		 System.out.println(userMapper);
		   User user = new User();
		   user.setUserage("18");
		   user.setUsername("张三");
		   //user.setId(123);
		 userMapper.save(user);
	 }
}
