package com.wang.test;


import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.wang.provider.DemoService;

public class RPCUtil {
	private static volatile Map<Class,Object> map = new ConcurrentHashMap<Class,Object>();
	
	public static void main(String[] args) throws IOException {
	   DemoService demoService = RPCUtil.getInstance(DemoService.class);
	   System.in.read(); 
  }
	
	private static <T extends Object> void init(Class<T> t){
		ApplicationConfig application = new ApplicationConfig();
		application.setName("xzysconsumer");
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("zookeeper://127.0.0.1:2181");
		registry.setClient("curator");
		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
		// 引用远程服务
		ReferenceConfig<T> reference = new ReferenceConfig<T>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(t);
		reference.setVersion("1.0.0");
		reference.setCheck(false);
		
		// 和本地bean一样使用xxxService
//		promoterService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		map.put(t, reference.get());
	}
	public static <T extends Object> T getInstance(Class<T> t){
		if(!map.containsKey(t)){
			synchronized (map) {
				if(!map.containsKey(t)){
					init(t);
				}
			}
		}
		return (T)map.get(t);
	}
}
