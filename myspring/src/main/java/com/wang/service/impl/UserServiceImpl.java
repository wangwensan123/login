package com.wang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wang.mapper.UserMapper;
import com.wang.model.User;
import com.wang.service.UserService;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<User> findAll() {
		List<User> findAllList = mapper.findAll();
		return findAllList;
	}

	public User findById(int id) {

		User user = mapper.findById(id);
		
		return user;
	}
	
	 public User findByName(String name) {

	    User user = mapper.findByName(name);
	    
	    return user;
	  }

	public void save(User user) {

		mapper.save(user);
	}

	public boolean update(User user) {

		return mapper.update(user);
	}
	
	

}
