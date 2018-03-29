package com.wang.test;
/**
 *@auth wws
 *@date 2018年3月29日---下午12:29:03
 *
 **/
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wang.util.RedisCacheUtil;


/**
 * 测试
 */
public class RedisTest {


    
    public static void main(String[] args) throws Exception {
         RedisCacheUtil redisCache;
         String key;
         String field;
         String value;
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-common.xml");
        context.start();
        redisCache = (RedisCacheUtil) context.getBean("redisCache");
        key = "tb_student";
        field = "stu_name";
        value = "一系列的关于student的信息！";
        redisCache.hset(key, field, value);
        System.out.println("数据保存成功！");
        String re = redisCache.hget(key, field);
        System.out.println("得到的数据：" + re);
        long size = redisCache.hsize(key);
        System.out.println("数量为：" + size);
    }

}
