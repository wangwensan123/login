package com.wang.test;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;

import com.wang.mapper.UserMapper;
import com.wang.model.User;

public class SpringTest {

	 public static void main(String[] args) {
//		 ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-common.xml");
//		 UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");
//		 System.out.println(userMapper);
//		   User user = new User();
//		   user.setUserage("18");
//		   user.setUsername("张三");
		   //user.setId(123);
		 //userMapper.save(user);
//		 DefaultListableBeanFactory dlbf = 
   BeanFactory bf = new XmlBeanFactory(new ClassPathResource("spring-common1.xml"));
   System.out.println(StringUtils.cleanPath("spring-common1.xml"));
   User userMapper = (User)bf.getBean("user");
   System.out.println(userMapper);
   User user = new User();
   user.setUserage("18");
   user.setUsername("张三");
	 }
}
