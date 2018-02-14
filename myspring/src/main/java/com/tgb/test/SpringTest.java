package com.tgb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tgb.mapper.UserMapper;
import com.tgb.model.User;

public class SpringTest {

	 public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring-common.xml");
		 UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
		 System.out.println(userMapper);
		   User user = new User();
		   user.setAge("18");
		   user.setUserName("张三");
		   //user.setId(123);
		 userMapper.save(user);
	 }
}
