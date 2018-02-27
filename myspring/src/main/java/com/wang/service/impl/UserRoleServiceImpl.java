package com.wang.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wang.mapper.UserRoleMapper;
import com.wang.model.UserRole;
import com.wang.service.UserRoleService;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserRoleServiceImpl implements UserRoleService {
	
	@Resource
	private UserRoleMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}


	public UserRole findById(int id) {

	  UserRole userRole = mapper.findById(id);
		
		return userRole;
	}
	

	public void save(UserRole userRole) {

		mapper.save(userRole);
	}
	
	

}
