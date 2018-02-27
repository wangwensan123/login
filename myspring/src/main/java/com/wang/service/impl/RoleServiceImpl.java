package com.wang.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.wang.mapper.RoleMapper;
import com.wang.model.Role;
import com.wang.service.RoleService;



@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleMapper mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<Role> findAll() {
		List<Role> findAllList = mapper.findAll();
		return findAllList;
	}

	public Role findById(int id) {

	  Role role = mapper.findById(id);
		
		return role;
	}
	
	 public Role findByName(String name) {

	   Role role = mapper.findByName(name);
	    
	    return role;
	  }

	public void save(Role role) {

		mapper.save(role);
	}

	public boolean update(Role role) {

		return mapper.update(role);
	}
	
	

}
